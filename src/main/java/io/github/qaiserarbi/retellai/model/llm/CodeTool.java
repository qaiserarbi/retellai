package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * A tool that executes JavaScript code in a sandbox.
 *
 * @param name                        unique name of the tool.
 * @param description                 describes what the tool does and when to call it.
 * @param code                        JavaScript code to execute in the sandbox.
 * @param timeoutMs                   maximum time in milliseconds the code can run before timeout.
 * @param responseVariables           mapping of variable names to JSON paths in the execution result.
 * @param speakDuringExecution        whether the agent speaks during execution.
 * @param speakAfterExecution         whether the agent speaks after the result is obtained.
 * @param executionMessageDescription description for the sentence said during execution.
 * @param executionMessageType        type of execution message (prompt or static_text).
 * @param enableTypingSound           if true, play a typing sound while the tool executes.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CodeTool(
        String name,
        String description,
        String code,
        Integer timeoutMs,
        Map<String, String> responseVariables,
        Boolean speakDuringExecution,
        Boolean speakAfterExecution,
        String executionMessageDescription,
        ExecutionMessageType executionMessageType,
        Boolean enableTypingSound
) implements Tool {
}
