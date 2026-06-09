package io.github.qaiserarbi.retellai.exception;

/** HTTP 422 &mdash; the request was well-formed but semantically invalid (validation failure). */
public final class RetellUnprocessableEntityException extends RetellApiException {
    RetellUnprocessableEntityException(String apiMessage, String rawBody, String requestId) {
        super(422, apiMessage, rawBody, requestId);
    }
}
