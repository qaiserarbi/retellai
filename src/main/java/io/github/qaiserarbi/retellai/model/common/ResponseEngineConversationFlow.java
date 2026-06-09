package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Response engine backed by a Conversation Flow.
 *
 * @param conversationFlowId ID of the Conversation Flow Response Engine.
 * @param version            version of the Conversation Flow Response Engine.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseEngineConversationFlow(
        String conversationFlowId,
        Double version
) implements ResponseEngine {
}
