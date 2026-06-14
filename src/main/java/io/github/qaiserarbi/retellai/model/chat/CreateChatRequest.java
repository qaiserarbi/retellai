package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/**
 * Request body for creating a chat session.
 *
 * @param agentId                   the chat agent to use for the chat.
 * @param agentVersion              the version of the chat agent (defaults to latest).
 * @param metadata                  arbitrary storage-only object associated with the chat.
 * @param retellLlmDynamicVariables dynamic variables injected into the Response Engine prompt.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateChatRequest(
        String agentId,
        AgentVersionReference agentVersion,
        Map<String, Object> metadata,
        Map<String, String> retellLlmDynamicVariables) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateChatRequest}. */
    public static final class Builder {
        private String agentId;
        private AgentVersionReference agentVersion;
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

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder retellLlmDynamicVariables(Map<String, String> retellLlmDynamicVariables) {
            this.retellLlmDynamicVariables = retellLlmDynamicVariables;
            return this;
        }

        public CreateChatRequest build() {
            return new CreateChatRequest(agentId, agentVersion, metadata,
                    retellLlmDynamicVariables);
        }
    }
}
