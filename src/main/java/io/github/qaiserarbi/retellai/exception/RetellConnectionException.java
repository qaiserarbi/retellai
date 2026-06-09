package io.github.qaiserarbi.retellai.exception;

/**
 * Thrown when a request to the Retell API could not complete at the transport layer &mdash;
 * i.e. no HTTP status was ever received. Causes include connection refused, read/connect
 * timeouts, DNS failures, TLS handshake errors, or an unreadable response body.
 */
public final class RetellConnectionException extends RetellException {

    public RetellConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
