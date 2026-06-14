package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.chat.ChatMessageInput;
import java.util.List;
import java.util.Map;

/**
 * Request body for a stateless agent playground completion. Send the full
 * conversation history; the server returns only the newly generated messages
 * and nothing is persisted.
 *
 * @param messages          full conversation history (same shape as chat completion messages)
 * @param dynamicVariables  key-value pairs for dynamic variable substitution
 * @param toolMocks         optional mock responses for tools
 * @param currentState      current state name for retell-llm agents (resume from a specific state)
 * @param currentNodeId     current node id for conversation-flow agents (resume from a specific node)
 * @param componentId       conversation flow component id (required when currentNodeId refers to a node within a component)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentPlaygroundCompletionRequest(
        List<ChatMessageInput> messages,
        Map<String, String> dynamicVariables,
        List<ToolMock> toolMocks,
        String currentState,
        String currentNodeId,
        String componentId
) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link AgentPlaygroundCompletionRequest}. */
    public static final class Builder {
        private List<ChatMessageInput> messages;
        private Map<String, String> dynamicVariables;
        private List<ToolMock> toolMocks;
        private String currentState;
        private String currentNodeId;
        private String componentId;

        private Builder() {
        }

        public Builder messages(List<ChatMessageInput> messages) {
            this.messages = messages;
            return this;
        }

        public Builder dynamicVariables(Map<String, String> dynamicVariables) {
            this.dynamicVariables = dynamicVariables;
            return this;
        }

        public Builder toolMocks(List<ToolMock> toolMocks) {
            this.toolMocks = toolMocks;
            return this;
        }

        public Builder currentState(String currentState) {
            this.currentState = currentState;
            return this;
        }

        public Builder currentNodeId(String currentNodeId) {
            this.currentNodeId = currentNodeId;
            return this;
        }

        public Builder componentId(String componentId) {
            this.componentId = componentId;
            return this;
        }

        public AgentPlaygroundCompletionRequest build() {
            return new AgentPlaygroundCompletionRequest(messages, dynamicVariables, toolMocks, currentState, currentNodeId, componentId);
        }
    }
}
