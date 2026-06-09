package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * SMS content inferred by the model from the prompt and call transcript.
 *
 * @param prompt the prompt used to help infer the SMS content. Can contain dynamic variables.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SmsContentInferred(
        String prompt) implements SmsContent {
}
