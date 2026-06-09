package io.github.qaiserarbi.retellai.model.chat;

import java.util.List;
import java.util.Map;

/**
 * A chat session.
 *
 * @param chatId                     unique id of the chat.
 * @param agentId                    corresponding chat agent id of this chat.
 * @param version                    the version of the agent.
 * @param retellLlmDynamicVariables  dynamic variables injected into the Response Engine prompt.
 * @param collectedDynamicVariables  dynamic variables collected from the chat (after it ends).
 * @param chatStatus                 status of the chat.
 * @param chatType                   type of the chat.
 * @param customAttributes           custom attributes for the chat.
 * @param startTimestamp             begin timestamp (milliseconds since epoch) of the chat.
 * @param endTimestamp               end timestamp (milliseconds since epoch) of the chat.
 * @param transcript                 transcription of the chat.
 * @param messageWithToolCalls       transcript woven with tool call invocations and results.
 * @param metadata                   arbitrary storage-only object.
 * @param chatCost                   cost breakdown of the chat.
 * @param chatAnalysis               post-chat analysis (available after the chat ends).
 */
public record ChatResponse(
        String chatId,
        String agentId,
        Integer version,
        Map<String, String> retellLlmDynamicVariables,
        Map<String, String> collectedDynamicVariables,
        ChatStatus chatStatus,
        ChatType chatType,
        Map<String, Object> customAttributes,
        Long startTimestamp,
        Long endTimestamp,
        String transcript,
        List<MessageOrToolCall> messageWithToolCalls,
        Map<String, Object> metadata,
        ChatCost chatCost,
        ChatAnalysis chatAnalysis) {
}
