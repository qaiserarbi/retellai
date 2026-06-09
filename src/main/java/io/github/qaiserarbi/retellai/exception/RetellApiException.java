package io.github.qaiserarbi.retellai.exception;

import java.util.Optional;

/**
 * Thrown when the Retell API returns a non-2xx HTTP response.
 *
 * <p>Retell error bodies follow the shape {@code {"status":"error","message":"..."}}. Both the
 * HTTP status code and the parsed {@code message} are exposed, alongside the raw response body
 * and the {@code x-request-id} header (useful when contacting Retell support).
 *
 * <p>Prefer catching the specific subclasses ({@link RetellAuthenticationException},
 * {@link RetellRateLimitException}, {@link RetellUnprocessableEntityException}, &hellip;) where you want
 * to branch on failure mode; catch this base type to handle any API error uniformly.
 */
public sealed class RetellApiException extends RetellException
        permits RetellBadRequestException, RetellAuthenticationException, RetellPaymentRequiredException,
                RetellPermissionException, RetellNotFoundException, RetellConflictException,
                RetellUnprocessableEntityException, RetellRateLimitException, RetellServerException,
                RetellApiException.Generic {

    private final int statusCode;
    private final String apiMessage;
    private final String rawBody;
    private final String requestId;

    RetellApiException(int statusCode, String apiMessage, String rawBody, String requestId) {
        super("Retell API error %d: %s".formatted(statusCode, apiMessage != null ? apiMessage : "(no message)"));
        this.statusCode = statusCode;
        this.apiMessage = apiMessage;
        this.rawBody = rawBody;
        this.requestId = requestId;
    }

    /** The HTTP status code returned by the API (e.g. 401, 422, 500). */
    public int statusCode() {
        return statusCode;
    }

    /** The {@code message} field parsed from the error body, if present. */
    public Optional<String> apiMessage() {
        return Optional.ofNullable(apiMessage);
    }

    /** The raw, unparsed response body. Always present, may be empty. */
    public String rawBody() {
        return rawBody == null ? "" : rawBody;
    }

    /** The {@code x-request-id} response header, if the API supplied one. */
    public Optional<String> requestId() {
        return Optional.ofNullable(requestId);
    }

    /**
     * Builds the most specific {@link RetellApiException} subclass for the given HTTP status.
     *
     * @param retryAfterSeconds the parsed {@code Retry-After} header for 429 responses, or {@code null}
     */
    public static RetellApiException of(int statusCode, String apiMessage, String rawBody,
                                        String requestId, Long retryAfterSeconds) {
        return switch (statusCode) {
            case 400 -> new RetellBadRequestException(apiMessage, rawBody, requestId);
            case 401 -> new RetellAuthenticationException(apiMessage, rawBody, requestId);
            case 402 -> new RetellPaymentRequiredException(apiMessage, rawBody, requestId);
            case 403 -> new RetellPermissionException(apiMessage, rawBody, requestId);
            case 404 -> new RetellNotFoundException(apiMessage, rawBody, requestId);
            case 409 -> new RetellConflictException(apiMessage, rawBody, requestId);
            case 422 -> new RetellUnprocessableEntityException(apiMessage, rawBody, requestId);
            case 429 -> new RetellRateLimitException(apiMessage, rawBody, requestId, retryAfterSeconds);
            default -> {
                if (statusCode >= 500) {
                    yield new RetellServerException(statusCode, apiMessage, rawBody, requestId);
                }
                yield new Generic(statusCode, apiMessage, rawBody, requestId);
            }
        };
    }

    /** Fallback for status codes without a dedicated subclass (e.g. an unexpected 4xx). */
    public static final class Generic extends RetellApiException {
        Generic(int statusCode, String apiMessage, String rawBody, String requestId) {
            super(statusCode, apiMessage, rawBody, requestId);
        }
    }
}
