package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Post call analysis setting used by an {@link AgentSwapNode}, controlling which agents'
 * post-call analysis runs after an agent swap.
 */
public enum PostCallAnalysisSetting {
    BOTH_AGENTS("both_agents"),
    ONLY_DESTINATION_AGENT("only_destination_agent");

    private final String value;

    PostCallAnalysisSetting(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PostCallAnalysisSetting from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown PostCallAnalysisSetting: " + v);
    }
}
