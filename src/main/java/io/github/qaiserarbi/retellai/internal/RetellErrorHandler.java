package io.github.qaiserarbi.retellai.internal;

import io.github.qaiserarbi.retellai.exception.RetellApiException;
import io.github.qaiserarbi.retellai.model.common.RetellApiError;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Translates non-2xx HTTP responses into the SDK's typed {@link RetellApiException} hierarchy.
 * Registered as the {@link RestClient} default status handler for every error status code.
 */
final class RetellErrorHandler {

    private final JsonMapper json;

    RetellErrorHandler(JsonMapper json) {
        this.json = json;
    }

    /** Wires this handler into the given builder for all error (4xx/5xx) status codes. */
    void apply(RestClient.Builder builder) {
        builder.defaultStatusHandler(HttpStatusCode::isError, this::handle);
    }

    private void handle(HttpRequest request, ClientHttpResponse response) throws IOException {
        int status = response.getStatusCode().value();
        String rawBody = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);
        String requestId = response.getHeaders().getFirst("x-request-id");
        Long retryAfter = parseRetryAfter(response.getHeaders().getFirst("retry-after"));
        throw RetellApiException.of(status, extractMessage(rawBody), rawBody, requestId, retryAfter);
    }

    private String extractMessage(String rawBody) {
        if (rawBody == null || rawBody.isBlank()) {
            return null;
        }
        try {
            RetellApiError error = json.readValue(rawBody, RetellApiError.class);
            return error.message();
        } catch (RuntimeException notJson) {
            return null; // body was empty, HTML, or otherwise not the expected error shape
        }
    }

    private Long parseRetryAfter(String headerValue) {
        if (headerValue == null || headerValue.isBlank()) {
            return null;
        }
        try {
            return Long.parseLong(headerValue.trim());
        } catch (NumberFormatException httpDateForm) {
            return null; // Retry-After as an HTTP date is not converted to seconds here
        }
    }
}
