package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of response engine used as a query filter for test listing endpoints.
 */
public enum ResponseEngineType {
    RETELL_LLM("retell-llm"), CONVERSATION_FLOW("conversation-flow");

    private final String value;

    ResponseEngineType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ResponseEngineType from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ResponseEngineType: " + v);
    }

    @Override
    public String toString() {
        return value;
    }
}
