package io.github.qaiserarbi.retellai.exception;

/** HTTP 404 &mdash; the requested resource does not exist under this API key. */
public final class RetellNotFoundException extends RetellApiException {
    RetellNotFoundException(String apiMessage, String rawBody, String requestId) {
        super(404, apiMessage, rawBody, requestId);
    }
}
