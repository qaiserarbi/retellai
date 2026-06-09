package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Request to publish an existing draft agent version in place.
 *
 * @param version            the draft version to publish
 * @param versionDescription optional description for the published version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PublishAgentVersionRequest(
        Integer version,
        String versionDescription
) {
}
