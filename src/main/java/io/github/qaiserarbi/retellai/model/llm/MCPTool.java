package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * A tool backed by an MCP (Model Context Protocol) server.
 *
 * @param mcpId                       unique id of the MCP.
 * @param name                        name of the MCP tool.
 * @param description                 description of the MCP tool.
 * @param inputSchema                 the input schema of the MCP tool.
 * @param responseVariables           mapping of variable names to JSON paths in the response.
 * @param speakDuringExecution        whether the agent speaks during execution.
 * @param speakAfterExecution         whether the agent speaks after the result is obtained.
 * @param executionMessageDescription description for the sentence said during execution.
 * @param executionMessageType        type of execution message (prompt or static_text).
 * @param enableTypingSound           if true, play a typing sound while the tool executes.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MCPTool(
        String mcpId,
        String name,
        String description,
        Map<String, String> inputSchema,
        Map<String, String> responseVariables,
        Boolean speakDuringExecution,
        Boolean speakAfterExecution,
        String executionMessageDescription,
        ExecutionMessageType executionMessageType,
        Boolean enableTypingSound
) implements Tool {
}
