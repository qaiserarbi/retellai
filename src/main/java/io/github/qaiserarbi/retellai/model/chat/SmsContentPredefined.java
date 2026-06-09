package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * SMS content that sends a static, predefined message.
 *
 * @param content the static message to be sent. Can contain dynamic variables.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SmsContentPredefined(
        String content) implements SmsContent {
}
