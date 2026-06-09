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
}
