package io.github.qaiserarbi.retellai.exception;

/** HTTP 403 &mdash; the API key is valid but not permitted to perform this action. */
public final class RetellPermissionException extends RetellApiException {
    RetellPermissionException(String apiMessage, String rawBody, String requestId) {
        super(403, apiMessage, rawBody, requestId);
    }
}
