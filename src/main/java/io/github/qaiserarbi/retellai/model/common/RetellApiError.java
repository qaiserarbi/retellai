package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The body Retell returns for a failed request: {@code {"status":"error","message":"..."}}.
 * Parsed by the SDK to populate {@link io.github.qaiserarbi.retellai.exception.RetellApiException}.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RetellApiError(String status, String message) {
}
