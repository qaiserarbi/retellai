package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Webhook setting for an agent swap, controlling which agents receive webhooks.
 */
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
