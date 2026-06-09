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
}
