package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * A tool that transfers the call to another destination.
 *
 * @param name                        unique name of the tool.
 * @param description                 describes what the tool does and when to call it.
 * @param transferDestination         the destination of the transfer.
 * @param ignoreE164Validation        if true, skip E.164 validation for the from_number.
 * @param customSipHeaders            custom SIP headers to add to the call.
 * @param transferOption              the transfer option (cold, warm, or agentic warm).
 * @param speakDuringExecution        if true, will speak during execution.
 * @param executionMessageDescription what to say to the user when transferring the call.
 * @param executionMessageType        type of execution message (prompt or static_text).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransferCallTool(
        String name,
        String description,
        TransferDestination transferDestination,
        Boolean ignoreE164Validation,
        Map<String, String> customSipHeaders,
        TransferOption transferOption,
        Boolean speakDuringExecution,
        String executionMessageDescription,
        ExecutionMessageType executionMessageType
) implements Tool {
}
