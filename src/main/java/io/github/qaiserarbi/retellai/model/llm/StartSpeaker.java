package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** The speaker who starts the conversation. */
public enum StartSpeaker {
    USER("user"),
    AGENT("agent");

    private final String value;

    StartSpeaker(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static StartSpeaker from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown StartSpeaker: " + v);
    }
}
