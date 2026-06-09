package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Webhook setting for the agent swap. */
public enum AgentSwapWebhookSetting {
    BOTH_AGENTS("both_agents"),
    ONLY_DESTINATION_AGENT("only_destination_agent"),
    ONLY_SOURCE_AGENT("only_source_agent");

    private final String value;

    AgentSwapWebhookSetting(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static AgentSwapWebhookSetting from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown AgentSwapWebhookSetting: " + v);
    }
}
