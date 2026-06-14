package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/** Request body for registering a phone call for custom telephony. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RegisterPhoneCallRequest(
        String agentId,
        AgentVersionReference agentVersion,
        AgentOverrideRequest agentOverride,
        String fromNumber,
        String toNumber,
        CallDirection direction,
        Map<String, Object> metadata,
        Map<String, String> retellLlmDynamicVariables) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link RegisterPhoneCallRequest}. */
    public static final class Builder {
        private String agentId;
        private AgentVersionReference agentVersion;
        private AgentOverrideRequest agentOverride;
        private String fromNumber;
        private String toNumber;
        private CallDirection direction;
        private Map<String, Object> metadata;
        private Map<String, String> retellLlmDynamicVariables;

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

        public Builder fromNumber(String fromNumber) {
            this.fromNumber = fromNumber;
            return this;
        }

        public Builder toNumber(String toNumber) {
            this.toNumber = toNumber;
            return this;
        }

        public Builder direction(CallDirection direction) {
            this.direction = direction;
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

        public RegisterPhoneCallRequest build() {
            return new RegisterPhoneCallRequest(agentId, agentVersion, agentOverride, fromNumber, toNumber, direction, metadata, retellLlmDynamicVariables);
        }
    }
}
