package io.github.qaiserarbi.retellai.exception;

/** HTTP 409 &mdash; the request conflicts with the current state of the resource. */
public final class RetellConflictException extends RetellApiException {
    RetellConflictException(String apiMessage, String rawBody, String requestId) {
        super(409, apiMessage, rawBody, requestId);
    }
}
