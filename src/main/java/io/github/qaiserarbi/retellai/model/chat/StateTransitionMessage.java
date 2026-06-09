package io.github.qaiserarbi.retellai.model.chat;

/**
 * A state transition woven into the chat transcript.
 *
 * @param role             discriminator role ({@code state_transition}).
 * @param messageId        unique id of the message.
 * @param formerStateName  former state name.
 * @param newStateName     new state name.
 * @param createdTimestamp create timestamp (milliseconds since epoch) of the message.
 */
public record StateTransitionMessage(
        MessageRole role,
        String messageId,
        String formerStateName,
        String newStateName,
        Long createdTimestamp) implements MessageOrToolCall {
}
