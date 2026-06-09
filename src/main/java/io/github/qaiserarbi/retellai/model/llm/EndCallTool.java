package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A tool that ends the call with the user.
 *
 * @param name                        unique name of the tool.
 * @param description                 describes what the tool does and when to call it.
 * @param speakDuringExecution        if true, will speak during execution.
 * @param executionMessageDescription what to say to the user when ending the call.
 * @param executionMessageType        type of execution message (prompt or static_text).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EndCallTool(
        String name,
        String description,
        Boolean speakDuringExecution,
        String executionMessageDescription,
        ExecutionMessageType executionMessageType
) implements Tool {
}
