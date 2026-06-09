package io.github.qaiserarbi.retellai.model.phone;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Type of the phone number. */
public enum PhoneNumberType {
    RETELL_TWILIO("retell-twilio"),
    RETELL_TELNYX("retell-telnyx"),
    CUSTOM("custom");

    private final String value;

    PhoneNumberType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PhoneNumberType from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown PhoneNumberType: " + v);
    }
}
