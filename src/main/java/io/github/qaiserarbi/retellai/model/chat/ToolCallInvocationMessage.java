package io.github.qaiserarbi.retellai.model.chat;

/**
 * A tool call invocation woven into the chat transcript.
 *
 * @param role             discriminator role ({@code tool_call_invocation}).
 * @param messageId        unique id of the message.
 * @param toolCallId       tool call id, globally unique.
 * @param name             name of the function in this tool call.
 * @param arguments        arguments for this tool call, a stringified JSON object.
 * @param thoughtSignature optional thought signature from Google Gemini thinking models.
 * @param createdTimestamp create timestamp (milliseconds since epoch) of the message.
 */
public record ToolCallInvocationMessage(
        MessageRole role,
        String messageId,
        String toolCallId,
        String name,
        String arguments,
        String thoughtSignature,
        Long createdTimestamp) implements MessageOrToolCall {
}
