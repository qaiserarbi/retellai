package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Type of a call, used to distinguish between web call and phone call. */
public enum CallType {
    WEB_CALL("web_call"),
    PHONE_CALL("phone_call");

    private final String value;

    CallType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static CallType from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown CallType: " + v);
    }
}
