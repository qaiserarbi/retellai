package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A predefined SMS content.
 *
 * @param content the static message to be sent. Can contain dynamic variables.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SmsContentPredefined(
        String content
) implements SmsContent {
}
