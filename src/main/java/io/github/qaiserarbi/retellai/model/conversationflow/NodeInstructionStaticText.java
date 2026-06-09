package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Static-text node instruction.
 *
 * @param text the static text for the instruction.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record NodeInstructionStaticText(
        String text
) implements NodeInstruction {
}
