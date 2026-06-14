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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link PublishAgentVersionRequest}. */
    public static final class Builder {
        private Integer version;
        private String versionDescription;

        private Builder() {
        }

        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        public Builder versionDescription(String versionDescription) {
            this.versionDescription = versionDescription;
            return this;
        }

        public PublishAgentVersionRequest build() {
            return new PublishAgentVersionRequest(version, versionDescription);
        }
    }
}
