package io.github.qaiserarbi.retellai.model.chat;

import java.util.List;

/**
 * An SMS message exchanged during the chat. Woven into the transcript and shown
 * to the agent, but not part of the spoken conversation.
 *
 * @param role             discriminator role ({@code sms}).
 * @param messageId        unique id of the message.
 * @param content          text content of the SMS message.
 * @param multimedia       multimedia attachments (MMS).
 * @param createdTimestamp create timestamp (milliseconds since epoch) of the message.
 */
public record SmsMessage(
        MessageRole role,
        String messageId,
        String content,
        List<SmsMultimediaItem> multimedia,
        Long createdTimestamp) implements MessageOrToolCall {
}
