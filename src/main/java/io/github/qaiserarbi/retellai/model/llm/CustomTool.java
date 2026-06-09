package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * A custom tool that calls an external HTTP API.
 *
 * @param name                        unique name of the tool.
 * @param url                         the request URL.
 * @param description                 describes what the tool does and when to call it.
 * @param method                      HTTP method to use for the request (default POST).
 * @param headers                     headers to add to the request.
 * @param queryParams                 query parameters to append to the request URL.
 * @param parameters                  the parameters the function accepts (JSON Schema).
 * @param responseVariables           mapping of variable names to JSON paths in the response body.
 * @param speakDuringExecution        whether the agent speaks during execution.
 * @param speakAfterExecution         whether the agent speaks after the result is obtained.
 * @param executionMessageDescription description for the sentence said during execution.
 * @param executionMessageType        type of execution message (prompt or static_text).
 * @param timeoutMs                   maximum time in milliseconds the tool can run before timeout.
 * @param argsAtRoot                  if true, parameters are passed as root level JSON instead of nested.
 * @param enableTypingSound           if true, play a typing sound while the tool executes.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CustomTool(
        String name,
        String url,
        String description,
        HttpMethod method,
        Map<String, String> headers,
        Map<String, String> queryParams,
        ToolParameter parameters,
        Map<String, String> responseVariables,
        Boolean speakDuringExecution,
        Boolean speakAfterExecution,
        String executionMessageDescription,
        ExecutionMessageType executionMessageType,
        Integer timeoutMs,
        Boolean argsAtRoot,
        Boolean enableTypingSound
) implements Tool {
}
