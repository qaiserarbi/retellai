package io.github.qaiserarbi.retellai.exception;

/**
 * Base type for every exception thrown by the Retell SDK.
 *
 * <p>Two broad categories extend this:
 * <ul>
 *   <li>{@link RetellApiException} &mdash; the Retell API returned a non-2xx HTTP response.</li>
 *   <li>{@link RetellConnectionException} &mdash; the request never produced an HTTP response
 *       (connection refused, timeout, TLS failure, malformed response, &hellip;).</li>
 * </ul>
 *
 * <p>All SDK exceptions are unchecked so they compose cleanly with the synchronous,
 * value-returning HTTP interface methods.
 */
public abstract class RetellException extends RuntimeException {

    protected RetellException(String message) {
        super(message);
    }

    protected RetellException(String message, Throwable cause) {
        super(message, cause);
    }
}
