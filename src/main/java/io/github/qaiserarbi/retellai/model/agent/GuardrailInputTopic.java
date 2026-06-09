package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Prohibited user input topic category. */
public enum GuardrailInputTopic {
    PLATFORM_INTEGRITY_JAILBREAKING("platform_integrity_jailbreaking");

    private final String value;

    GuardrailInputTopic(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static GuardrailInputTopic from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown GuardrailInputTopic: " + v);
    }
}
