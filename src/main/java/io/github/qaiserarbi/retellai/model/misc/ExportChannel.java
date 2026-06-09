package io.github.qaiserarbi.retellai.model.misc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The channel of an export request.
 */
public enum ExportChannel {
    CALL("call"),
    CHAT("chat");

    private final String value;

    ExportChannel(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ExportChannel from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ExportChannel: " + v);
    }
}
