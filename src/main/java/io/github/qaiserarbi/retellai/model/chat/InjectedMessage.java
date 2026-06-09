package io.github.qaiserarbi.retellai.model.chat;

/**
 * External context injected into the conversation via the update-live-call API.
 * Not spoken by either party.
 *
 * @param role             discriminator role ({@code injected}).
 * @param messageId        unique id of the message.
 * @param content          the injected context text.
 * @param createdTimestamp create timestamp (milliseconds since epoch) of the message.
 */
public record InjectedMessage(
        MessageRole role,
        String messageId,
        String content,
        Long createdTimestamp) implements MessageOrToolCall {
}
