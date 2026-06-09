package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Whether speech-to-text focuses on latency or accuracy. */
public enum SttMode {
    FAST("fast"),
    ACCURATE("accurate"),
    CUSTOM("custom");

    private final String value;

    SttMode(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static SttMode from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown SttMode: " + v);
    }
}
