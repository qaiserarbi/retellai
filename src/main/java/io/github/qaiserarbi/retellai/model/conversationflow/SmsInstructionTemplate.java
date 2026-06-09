package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Template-based SMS node instruction. The {@code template} discriminator is fixed to
 * {@code template} and {@code template} value to {@code info_collection}.
 *
 * @param type     instruction type, always {@code template}.
 * @param template predefined template; only {@code info_collection} is supported.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SmsInstructionTemplate(
        String type,
        String template
) {
}
