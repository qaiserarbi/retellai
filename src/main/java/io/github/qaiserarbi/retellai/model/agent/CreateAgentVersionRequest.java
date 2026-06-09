package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Request to create a new draft agent version from a base version.
 *
 * @param baseVersion existing version used as the base when creating a new draft
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateAgentVersionRequest(Integer baseVersion) {
}
