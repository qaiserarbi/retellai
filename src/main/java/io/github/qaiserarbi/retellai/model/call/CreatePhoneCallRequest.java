package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/** Request body for creating an outbound phone call. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreatePhoneCallRequest(
        String fromNumber,
        String toNumber,
        String overrideAgentId,
        AgentVersionReference overrideAgentVersion,
        AgentOverrideRequest agentOverride,
        Map<String, Object> metadata,
        Map<String, String> retellLlmDynamicVariables,
        Map<String, String> customSipHeaders,
        Boolean ignoreE164Validation) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreatePhoneCallRequest}. */
    public static final class Builder {
        private String fromNumber;
        private String toNumber;
        private String overrideAgentId;
        private AgentVersionReference overrideAgentVersion;
        private AgentOverrideRequest agentOverride;
        private Map<String, Object> metadata;
        private Map<String, String> retellLlmDynamicVariables;
        private Map<String, String> customSipHeaders;
        private Boolean ignoreE164Validation;

        private Builder() {
        }

        public Builder fromNumber(String fromNumber) {
            this.fromNumber = fromNumber;
            return this;
        }

        public Builder toNumber(String toNumber) {
            this.toNumber = toNumber;
            return this;
        }

        public Builder overrideAgentId(String overrideAgentId) {
            this.overrideAgentId = overrideAgentId;
            return this;
        }

        public Builder overrideAgentVersion(AgentVersionReference overrideAgentVersion) {
            this.overrideAgentVersion = overrideAgentVersion;
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

        public Builder customSipHeaders(Map<String, String> customSipHeaders) {
            this.customSipHeaders = customSipHeaders;
            return this;
        }

        public Builder ignoreE164Validation(Boolean ignoreE164Validation) {
            this.ignoreE164Validation = ignoreE164Validation;
            return this;
        }

        public CreatePhoneCallRequest build() {
            return new CreatePhoneCallRequest(fromNumber, toNumber, overrideAgentId, overrideAgentVersion, agentOverride, metadata, retellLlmDynamicVariables, customSipHeaders, ignoreE164Validation);
        }
    }
}
