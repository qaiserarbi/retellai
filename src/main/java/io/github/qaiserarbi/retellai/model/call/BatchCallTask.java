package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/** An individual call task to be executed as part of a batch call. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BatchCallTask(
        String toNumber,
        Boolean ignoreE164Validation,
        String overrideAgentId,
        AgentVersionReference overrideAgentVersion,
        AgentOverrideRequest agentOverride,
        Map<String, String> retellLlmDynamicVariables,
        Map<String, Object> metadata,
        Map<String, String> customSipHeaders) {
}
