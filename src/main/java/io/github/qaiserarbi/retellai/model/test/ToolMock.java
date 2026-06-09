package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A mock response for a tool. When provided, the agent uses this instead of
 * executing the real tool call.
 *
 * @param toolName       name of the tool to mock
 * @param inputMatchRule rule for matching tool calls
 * @param output         the output of the tool call fed into the LLM; should be a JSON string
 * @param result         for tool calls like transfer_call that require a boolean result; optional for most tools
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolMock(
        String toolName,
        ToolMockInputMatchRule inputMatchRule,
        String output,
        Boolean result
) {
}
