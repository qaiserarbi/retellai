package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A tool (available to transfer agents in agentic warm transfer mode) that bridges the original
 * caller to the transfer target and ends the transfer agent call.
 *
 * @param name                        unique name of the tool.
 * @param description                 describes what the tool does.
 * @param speakDuringExecution        if true, will speak during execution.
 * @param executionMessageDescription what to say when bridging the transfer.
 * @param executionMessageType        type of execution message (prompt or static_text).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BridgeTransferTool(
        String name,
        String description,
        Boolean speakDuringExecution,
        String executionMessageDescription,
        ExecutionMessageType executionMessageType
) implements Tool {
}
