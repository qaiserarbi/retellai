package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * An inferred SMS content.
 *
 * @param prompt the prompt used to help infer the SMS content. Can contain dynamic variables.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SmsContentInferred(
        String prompt
) implements SmsContent {
}
