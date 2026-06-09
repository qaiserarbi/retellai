package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/** Request body for registering a phone call for custom telephony. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RegisterPhoneCallRequest(
        String agentId,
        AgentVersionReference agentVersion,
        AgentOverrideRequest agentOverride,
        String fromNumber,
        String toNumber,
        CallDirection direction,
        Map<String, Object> metadata,
        Map<String, String> retellLlmDynamicVariables) {
}
