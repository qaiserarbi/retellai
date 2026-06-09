package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Direction of a phone call. */
public enum CallDirection {
    INBOUND("inbound"),
    OUTBOUND("outbound");

    private final String value;

    CallDirection(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static CallDirection from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown CallDirection: " + v);
    }
}
