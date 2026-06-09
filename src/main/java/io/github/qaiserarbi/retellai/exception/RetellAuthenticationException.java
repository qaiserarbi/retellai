package io.github.qaiserarbi.retellai.exception;

/** HTTP 401 &mdash; the API key is missing or invalid. */
public final class RetellAuthenticationException extends RetellApiException {
    RetellAuthenticationException(String apiMessage, String rawBody, String requestId) {
        super(401, apiMessage, rawBody, requestId);
    }
}
