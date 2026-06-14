package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/** Request body for creating a web call. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateWebCallRequest(
        String agentId,
        AgentVersionReference agentVersion,
        AgentOverrideRequest agentOverride,
        Map<String, Object> metadata,
        Map<String, String> retellLlmDynamicVariables,
        String currentNodeId,
        String currentState) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateWebCallRequest}. */
    public static final class Builder {
        private String agentId;
        private AgentVersionReference agentVersion;
        private AgentOverrideRequest agentOverride;
        private Map<String, Object> metadata;
        private Map<String, String> retellLlmDynamicVariables;
        private String currentNodeId;
        private String currentState;

        private Builder() {
        }

        public Builder agentId(String agentId) {
            this.agentId = agentId;
            return this;
        }

        public Builder agentVersion(AgentVersionReference agentVersion) {
            this.agentVersion = agentVersion;
            return this;
        }

        public Builder agentOverride(AgentOverrideRequest agentOverride) {
            this.agentOverride = agentOverride;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder retellLlmDynamicVariables(Map<String, String> retellLlmDynamicVariables) {
            this.retellLlmDynamicVariables = retellLlmDynamicVariables;
            return this;
        }

        public Builder currentNodeId(String currentNodeId) {
            this.currentNodeId = currentNodeId;
            return this;
        }

        public Builder currentState(String currentState) {
            this.currentState = currentState;
            return this;
        }

        public CreateWebCallRequest build() {
            return new CreateWebCallRequest(agentId, agentVersion, agentOverride, metadata, retellLlmDynamicVariables, currentNodeId, currentState);
        }
    }
}
