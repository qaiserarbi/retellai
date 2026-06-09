package io.github.qaiserarbi.retellai.model.chat;

/**
 * A standard chat message sent by the agent or the user.
 *
 * @param role             whether this message is sent by the agent or the user.
 * @param messageId        unique id of the message.
 * @param content          content of the message.
 * @param createdTimestamp create timestamp (milliseconds since epoch) of the message.
 */
public record Message(
        MessageRole role,
        String messageId,
        String content,
        Long createdTimestamp) implements MessageOrToolCall {
}
