package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/** Request body for creating a web call. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateWebCallRequest(
        String agentId,
        AgentVersionReference agentVersion,
        AgentOverrideRequest agentOverride,
        Map<String, Object> metadata,
        Map<String, String> retellLlmDynamicVariables,
        String currentNodeId,
        String currentState) {
}
