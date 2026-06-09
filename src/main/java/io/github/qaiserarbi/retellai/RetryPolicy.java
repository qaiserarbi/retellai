package io.github.qaiserarbi.retellai;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

/**
 * Controls how the SDK retries transient failures. Applied to every request.
 *
 * <p>By default the SDK retries up to {@value #DEFAULT_MAX_RETRIES} times (so up to 3 total
 * attempts) on connection errors and on the transient status codes 408, 429, 500, 502, 503 and
 * 504, using exponential backoff with jitter and honouring a {@code Retry-After} header when the
 * server sends one. Non-transient errors (e.g. 400, 401, 404, 422) are never retried.
 *
 * <p><strong>Idempotency note:</strong> retries apply to all HTTP methods, including
 * non-idempotent {@code POST}s (e.g. creating a call). A request that timed out or failed with a
 * 5xx <em>may</em> still have been processed by Retell, so a retry could duplicate it. If that
 * matters for a given call site, use {@link #none()} or lower {@link Builder#maxRetries(int)}.
 */
public record RetryPolicy(
        int maxRetries,
        Duration baseDelay,
        Duration maxDelay,
        Set<Integer> retryableStatusCodes,
        boolean retryOnConnectionError,
        boolean respectRetryAfter) {

    public static final int DEFAULT_MAX_RETRIES = 2;
    public static final Set<Integer> DEFAULT_RETRYABLE_STATUS_CODES = Set.of(408, 429, 500, 502, 503, 504);

    public RetryPolicy {
        if (maxRetries < 0) {
            throw new IllegalArgumentException("maxRetries must be >= 0");
        }
        Objects.requireNonNull(baseDelay, "baseDelay");
        Objects.requireNonNull(maxDelay, "maxDelay");
        if (baseDelay.isNegative() || maxDelay.isNegative()) {
            throw new IllegalArgumentException("delays must be >= 0");
        }
        retryableStatusCodes = Set.copyOf(retryableStatusCodes);
    }

    /** The default resilient policy. */
    public static RetryPolicy defaults() {
        return builder().build();
    }

    /** A policy that disables all retries (fails fast on the first error). */
    public static RetryPolicy none() {
        return builder().maxRetries(0).retryOnConnectionError(false).build();
    }

    /** Whether the given HTTP status code should be retried under this policy. */
    public boolean isRetryableStatus(int statusCode) {
        return retryableStatusCodes.contains(statusCode);
    }

    public Builder toBuilder() {
        return new Builder()
                .maxRetries(maxRetries)
                .baseDelay(baseDelay)
                .maxDelay(maxDelay)
                .retryableStatusCodes(retryableStatusCodes)
                .retryOnConnectionError(retryOnConnectionError)
                .respectRetryAfter(respectRetryAfter);
    }

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link RetryPolicy}, pre-populated with the resilient defaults. */
    public static final class Builder {
        private int maxRetries = DEFAULT_MAX_RETRIES;
        private Duration baseDelay = Duration.ofMillis(500);
        private Duration maxDelay = Duration.ofSeconds(8);
        private Set<Integer> retryableStatusCodes = DEFAULT_RETRYABLE_STATUS_CODES;
        private boolean retryOnConnectionError = true;
        private boolean respectRetryAfter = true;

        private Builder() {
        }

        /** Maximum number of retries after the initial attempt (0 disables retries). */
        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        /** Base backoff delay; the delay grows exponentially from here. Default 500ms. */
        public Builder baseDelay(Duration baseDelay) {
            this.baseDelay = baseDelay;
            return this;
        }

        /** Upper bound on any single backoff delay. Default 8s. */
        public Builder maxDelay(Duration maxDelay) {
            this.maxDelay = maxDelay;
            return this;
        }

        /** The set of HTTP status codes to retry. */
        public Builder retryableStatusCodes(Set<Integer> retryableStatusCodes) {
            this.retryableStatusCodes = retryableStatusCodes;
            return this;
        }

        /** Whether to retry connection-level failures (timeouts, connection refused, …). */
        public Builder retryOnConnectionError(boolean retryOnConnectionError) {
            this.retryOnConnectionError = retryOnConnectionError;
            return this;
        }

        /** Whether to honour a {@code Retry-After} response header for backoff timing. */
        public Builder respectRetryAfter(boolean respectRetryAfter) {
            this.respectRetryAfter = respectRetryAfter;
            return this;
        }

        public RetryPolicy build() {
            return new RetryPolicy(maxRetries, baseDelay, maxDelay, retryableStatusCodes,
                    retryOnConnectionError, respectRetryAfter);
        }
    }
}
