package io.github.qaiserarbi.retellai.exception;

import java.util.Optional;

/** HTTP 429 &mdash; the account is being rate limited. Honour {@link #retryAfterSeconds()} if present. */
public final class RetellRateLimitException extends RetellApiException {

    private final Long retryAfterSeconds;

    RetellRateLimitException(String apiMessage, String rawBody, String requestId, Long retryAfterSeconds) {
        super(429, apiMessage, rawBody, requestId);
        this.retryAfterSeconds = retryAfterSeconds;
    }

    /** The value of the {@code Retry-After} response header in seconds, if the API supplied one. */
    public Optional<Long> retryAfterSeconds() {
        return Optional.ofNullable(retryAfterSeconds);
    }
}
