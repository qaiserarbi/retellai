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
}
