package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Type of execution message: prompt (generate from description) or static_text (speak directly). */
public enum ExecutionMessageType {
    PROMPT("prompt"),
    STATIC_TEXT("static_text");

    private final String value;

    ExecutionMessageType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ExecutionMessageType from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ExecutionMessageType: " + v);
    }
}
