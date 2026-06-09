package io.github.qaiserarbi.retellai.model.misc;

import java.util.Map;

/**
 * Definition of a tool exposed by an MCP server.
 *
 * @param name        name of the MCP tool.
 * @param description description of what the MCP tool does.
 * @param inputSchema JSON schema defining the input parameters for the tool.
 */
public record MCPToolDefinition(
        String name,
        String description,
        Map<String, Object> inputSchema
) {
}
