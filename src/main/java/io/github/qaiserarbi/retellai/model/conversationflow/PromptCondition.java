package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Prompt-based transition condition.
 *
 * @param prompt the prompt condition text.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PromptCondition(
        String prompt
) implements TransitionCondition {
}
