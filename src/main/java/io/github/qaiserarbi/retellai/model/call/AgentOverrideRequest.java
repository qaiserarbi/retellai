package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * Override configuration for agent, Retell LLM, or conversation flow settings for
 * a specific call. The {@code agent}, {@code retellLlm}, and
 * {@code conversationFlow} fields are loosely-typed partial configuration maps
 * whose accepted keys mirror the corresponding agent/response-engine settings.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentOverrideRequest(
        Map<String, Object> agent,
        Map<String, Object> retellLlm,
        Map<String, Object> conversationFlow) {
}
