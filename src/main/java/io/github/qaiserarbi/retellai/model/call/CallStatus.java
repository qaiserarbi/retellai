package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Status of a call. */
public enum CallStatus {
    REGISTERED("registered"),
    NOT_CONNECTED("not_connected"),
    ONGOING("ongoing"),
    ENDED("ended"),
    ERROR("error");

    private final String value;

    CallStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static CallStatus from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown CallStatus: " + v);
    }
}
