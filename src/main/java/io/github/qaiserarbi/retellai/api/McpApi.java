package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import io.github.qaiserarbi.retellai.model.misc.MCPToolDefinition;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

/**
 * Operations for retrieving MCP tool definitions for an agent.
 */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface McpApi {

    /**
     * Retrieve the MCP tools available to an agent from a given MCP server.
     *
     * @param agentId     unique id of the agent to get MCP tools for.
     * @param mcpId       the ID of the MCP server to get tools from.
     * @param version     optional version of the agent to use; defaults to the latest version.
     * @param componentId optional ID of the component if the MCP server is configured under a component.
     * @return the list of MCP tool definitions.
     */
    @GetExchange("/get-mcp-tools/{agent_id}")
    List<MCPToolDefinition> getMcpTools(
            @PathVariable("agent_id") String agentId,
            @RequestParam("mcp_id") String mcpId,
            @RequestParam(name = "version", required = false) AgentVersionReference version,
            @RequestParam(name = "component_id", required = false) String componentId);
}
