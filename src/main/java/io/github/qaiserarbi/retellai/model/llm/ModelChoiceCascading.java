package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Cascading model choice.
 *
 * @param model        the LLM model to use.
 * @param highPriority whether to use the high priority pool with more dedicated resource.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelChoiceCascading(
        LLMModel model,
        Boolean highPriority
) implements ModelChoice {
}
