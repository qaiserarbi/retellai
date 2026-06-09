package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Call screen handling instructions for identity and call purpose questions.
 *
 * @param agentIdentity identity the agent should provide when asked who is calling
 * @param callPurpose   purpose the agent should provide when asked why it is calling
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CallScreeningOption(
        String agentIdentity,
        String callPurpose
) {
}
