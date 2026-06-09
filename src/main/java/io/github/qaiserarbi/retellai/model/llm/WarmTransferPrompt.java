package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A prompt-based warm transfer handoff option.
 *
 * @param prompt the prompt to be used for warm handoff. Can contain dynamic variables.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record WarmTransferPrompt(
        String prompt
) implements WarmTransferHandoffOption {
}
