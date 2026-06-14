package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Request to create a new draft agent version from a base version.
 *
 * @param baseVersion existing version used as the base when creating a new draft
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateAgentVersionRequest(Integer baseVersion) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateAgentVersionRequest}. */
    public static final class Builder {
        private Integer baseVersion;

        private Builder() {
        }

        public Builder baseVersion(Integer baseVersion) {
            this.baseVersion = baseVersion;
            return this;
        }

        public CreateAgentVersionRequest build() {
            return new CreateAgentVersionRequest(baseVersion);
        }
    }
}
