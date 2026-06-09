package io.github.qaiserarbi.retellai.internal;

import io.github.qaiserarbi.retellai.RetryPolicy;
import io.github.qaiserarbi.retellai.exception.RetellConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Transport-level resilience: retries transient failures with exponential backoff + jitter, and
 * wraps unrecoverable connection failures in {@link RetellConnectionException}.
 *
 * <p>Sits below the {@link org.springframework.web.client.RestClient} status handler, so it can
 * observe the raw status code and any {@link IOException} and retry <em>before</em> a typed
 * {@link io.github.qaiserarbi.retellai.exception.RetellApiException} would be raised. A final,
 * non-retryable response is returned untouched for the status handler to map.
 */
final class RetryInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RetryInterceptor.class);

    private final RetryPolicy policy;

    RetryInterceptor(RetryPolicy policy) {
        this.policy = policy;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        int attempt = 0;
        while (true) {
            try {
                ClientHttpResponse response = execution.execute(request, body);
                int status = response.getStatusCode().value();
                if (attempt < policy.maxRetries() && policy.isRetryableStatus(status)) {
                    long delayMs = backoffMillis(attempt, retryAfterSeconds(response));
                    log.debug("Retrying {} {} after HTTP {} (attempt {}/{}, waiting {}ms)",
                            request.getMethod(), request.getURI(), status, attempt + 1, policy.maxRetries(), delayMs);
                    closeQuietly(response);
                    sleep(delayMs, request);
                    attempt++;
                    continue;
                }
                return response;
            } catch (IOException e) {
                if (policy.retryOnConnectionError() && attempt < policy.maxRetries()) {
                    long delayMs = backoffMillis(attempt, -1);
                    log.debug("Retrying {} {} after connection error '{}' (attempt {}/{}, waiting {}ms)",
                            request.getMethod(), request.getURI(), e.getMessage(), attempt + 1, policy.maxRetries(), delayMs);
                    sleep(delayMs, request);
                    attempt++;
                    continue;
                }
                throw new RetellConnectionException(
                        "Request %s %s failed after %d attempt(s): %s"
                                .formatted(request.getMethod(), request.getURI(), attempt + 1, e.getMessage()),
                        e);
            }
        }
    }

    /** Equal-jitter exponential backoff, capped at {@code maxDelay}; honours Retry-After if present. */
    private long backoffMillis(int attempt, long retryAfterSeconds) {
        long capMs = policy.maxDelay().toMillis();
        long exp = policy.baseDelay().toMillis() * (1L << Math.min(attempt, 30));
        long capped = Math.min(capMs, Math.max(0, exp));
        long jittered = capped <= 1 ? capped : ThreadLocalRandom.current().nextLong(capped / 2 + 1, capped + 1);
        if (policy.respectRetryAfter() && retryAfterSeconds >= 0) {
            jittered = Math.max(jittered, Math.min(retryAfterSeconds * 1000L, capMs));
        }
        return jittered;
    }

    private static long retryAfterSeconds(ClientHttpResponse response) {
        try {
            String header = response.getHeaders().getFirst("Retry-After");
            return header == null ? -1 : Long.parseLong(header.trim());
        } catch (RuntimeException notNumeric) {
            return -1; // absent, or an HTTP-date form we don't translate
        }
    }

    private static void closeQuietly(ClientHttpResponse response) {
        try {
            response.close();
        } catch (RuntimeException ignored) {
            // best effort: release the connection before retrying
        }
    }

    private static void sleep(long millis, HttpRequest request) {
        if (millis <= 0) {
            return;
        }
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RetellConnectionException(
                    "Interrupted while backing off before retrying " + request.getURI(), e);
        }
    }
}
