package io.github.qaiserarbi.retellai.model.chat;

/**
 * The result of a tool call woven into the chat transcript.
 *
 * @param role             discriminator role ({@code tool_call_result}).
 * @param messageId        unique id of the message.
 * @param toolCallId       tool call id, globally unique.
 * @param content          result of the tool call, can be a string or stringified JSON.
 * @param successful       whether the tool call was successful.
 * @param createdTimestamp create timestamp (milliseconds since epoch) of the message.
 */
public record ToolCallResultMessage(
        MessageRole role,
        String messageId,
        String toolCallId,
        String content,
        Boolean successful,
        Long createdTimestamp) implements MessageOrToolCall {
}
