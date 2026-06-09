package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Configuration for an agentic warm transfer.
 *
 * @param transferAgent    the agent that will mediate the transfer decision.
 * @param transferTimeoutMs the maximum time to wait for the transfer agent to decide, in milliseconds.
 * @param actionOnTimeout  the action to take when the transfer agent times out.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgenticTransferConfig(
        TransferAgent transferAgent,
        Double transferTimeoutMs,
        TransferActionOnTimeout actionOnTimeout
) {
}
