package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Processing mode for PII scrubbing. */
public enum PiiMode {
    POST_CALL("post_call");

    private final String value;

    PiiMode(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PiiMode from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown PiiMode: " + v);
    }
}
