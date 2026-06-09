package io.github.qaiserarbi.retellai.exception;

/** HTTP 402 &mdash; payment required (e.g. trial ended, no payment method on file). */
public final class RetellPaymentRequiredException extends RetellApiException {
    RetellPaymentRequiredException(String apiMessage, String rawBody, String requestId) {
        super(402, apiMessage, rawBody, requestId);
    }
}
