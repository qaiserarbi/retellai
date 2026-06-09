package io.github.qaiserarbi.retellai.exception;

/** HTTP 5xx &mdash; Retell encountered an internal error. Generally safe to retry with backoff. */
public final class RetellServerException extends RetellApiException {
    RetellServerException(int statusCode, String apiMessage, String rawBody, String requestId) {
        super(statusCode, apiMessage, rawBody, requestId);
    }
}
