package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;

/**
 * The agent that will mediate an agentic warm transfer decision.
 *
 * @param agentId      the agent ID of the transfer agent.
 * @param agentVersion the version of the transfer agent to use.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransferAgent(
        String agentId,
        AgentVersionReference agentVersion
) {
}
