package io.github.qaiserarbi.retellai.exception;

/** HTTP 400 &mdash; the request was malformed (invalid format or parameters). */
public final class RetellBadRequestException extends RetellApiException {
    RetellBadRequestException(String apiMessage, String rawBody, String requestId) {
        super(400, apiMessage, rawBody, requestId);
    }
}
