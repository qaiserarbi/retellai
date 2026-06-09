package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Prompt-based node instruction.
 *
 * @param text the prompt text for the instruction.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record NodeInstructionPrompt(
        String text
) implements NodeInstruction {
}
