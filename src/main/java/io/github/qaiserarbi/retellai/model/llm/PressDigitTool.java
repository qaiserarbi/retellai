package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A tool that presses a digit on the phone keypad (e.g. to navigate an IVR).
 *
 * @param name        unique name of the tool.
 * @param description describes what the tool does and when to call it.
 * @param delayMs     delay in milliseconds before pressing the digit.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PressDigitTool(
        String name,
        String description,
        Integer delayMs
) implements Tool {
}
