package io.github.qaiserarbi.retellai.model.chat;

/**
 * A multimedia (MMS) attachment on an SMS message. Display only; not relayed
 * into the spoken conversation.
 *
 * @param url     URL of the multimedia attachment.
 * @param summary optional textual summary of the attachment.
 */
public record SmsMultimediaItem(
        String url,
        String summary) {
}
