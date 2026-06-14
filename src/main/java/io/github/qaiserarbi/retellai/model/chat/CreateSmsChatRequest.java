package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/**
 * Request body for creating an SMS chat.
 *
 * @param fromNumber                the phone number to send SMS from (E.164). Must have SMS capability.
 * @param toNumber                  the phone number to send SMS to (E.164).
 * @param overrideAgentId           one-time override of the agent used for this chat.
 * @param overrideAgentVersion      one-time override of the agent version used for this chat.
 * @param metadata                  arbitrary storage-only object associated with the chat.
 * @param retellLlmDynamicVariables dynamic variables injected into the Response Engine prompt.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateSmsChatRequest(
        String fromNumber,
        String toNumber,
        String overrideAgentId,
        AgentVersionReference overrideAgentVersion,
        Map<String, Object> metadata,
        Map<String, String> retellLlmDynamicVariables) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateSmsChatRequest}. */
    public static final class Builder {
        private String fromNumber;
        private String toNumber;
        private String overrideAgentId;
        private AgentVersionReference overrideAgentVersion;
        private Map<String, Object> metadata;
        private Map<String, String> retellLlmDynamicVariables;

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

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder retellLlmDynamicVariables(Map<String, String> retellLlmDynamicVariables) {
            this.retellLlmDynamicVariables = retellLlmDynamicVariables;
            return this;
        }

        public CreateSmsChatRequest build() {
            return new CreateSmsChatRequest(fromNumber, toNumber, overrideAgentId,
                    overrideAgentVersion, metadata, retellLlmDynamicVariables);
        }
    }
}
