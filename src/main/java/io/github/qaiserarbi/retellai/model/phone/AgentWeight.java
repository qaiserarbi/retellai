package io.github.qaiserarbi.retellai.model.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;

/**
 * An agent binding with a weight, used to randomly select an agent for a call or SMS.
 * When used in a list of agents, the total weights must add up to 1.
 *
 * @param agentId       the agent ID
 * @param agentVersion  optional agent version reference (numeric version or tag)
 * @param weight        the weight of the agent (0 exclusive to 1 inclusive)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentWeight(
        String agentId,
        AgentVersionReference agentVersion,
        Double weight
) {}
