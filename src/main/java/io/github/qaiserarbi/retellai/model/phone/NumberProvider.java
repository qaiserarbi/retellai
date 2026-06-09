package io.github.qaiserarbi.retellai.model.phone;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** The provider to purchase the phone number from. */
public enum NumberProvider {
    TWILIO("twilio"),
    TELNYX("telnyx");

    private final String value;

    NumberProvider(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static NumberProvider from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown NumberProvider: " + v);
    }
}
