package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * SMS content that uses a predefined template.
 *
 * @param template the template to use for the SMS content (e.g. {@code info_collection}).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SmsContentTemplate(
        String template) implements SmsContent {
}
