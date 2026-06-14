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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link AgentOverrideRequest}. */
    public static final class Builder {
        private Map<String, Object> agent;
        private Map<String, Object> retellLlm;
        private Map<String, Object> conversationFlow;

        private Builder() {
        }

        public Builder agent(Map<String, Object> agent) {
            this.agent = agent;
            return this;
        }

        public Builder retellLlm(Map<String, Object> retellLlm) {
            this.retellLlm = retellLlm;
            return this;
        }

        public Builder conversationFlow(Map<String, Object> conversationFlow) {
            this.conversationFlow = conversationFlow;
            return this;
        }

        public AgentOverrideRequest build() {
            return new AgentOverrideRequest(agent, retellLlm, conversationFlow);
        }
    }
}
