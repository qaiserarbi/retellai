package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A single utterance within a finetune example transcript. Covers the three role shapes in the
 * spec (agent/user message, tool-call invocation, and tool-call result) as a single record; the
 * fields that do not apply to a given {@code role} remain {@code null}.
 *
 * @param role       the role of the utterance: {@code agent}, {@code user},
 *                   {@code tool_call_invocation}, or {@code tool_call_result}.
 * @param content    text content (for agent/user messages and tool-call results).
 * @param toolCallId the tool call id (for tool-call invocation and result).
 * @param name       the tool name (for tool-call invocation).
 * @param arguments  the tool-call arguments JSON string (for tool-call invocation).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FinetuneExampleUtterance(
        String role,
        String content,
        @JsonProperty("tool_call_id") String toolCallId,
        String name,
        String arguments
) {
}
