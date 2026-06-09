package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * An MCP (Model Context Protocol) server configuration to use for an LLM.
 *
 * @param name        name of the MCP server.
 * @param url         the URL of the MCP server.
 * @param headers     headers to add to the MCP connection request.
 * @param queryParams query parameters to append to the MCP connection request URL.
 * @param timeoutMs   maximum time to wait for a connection to be established, in milliseconds.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MCP(
        String name,
        String url,
        Map<String, String> headers,
        Map<String, String> queryParams,
        Integer timeoutMs
) {
}
