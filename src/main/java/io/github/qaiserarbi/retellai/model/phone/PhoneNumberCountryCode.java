package io.github.qaiserarbi.retellai.model.phone;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** The ISO 3166-1 alpha-2 country code of the number to purchase. */
public enum PhoneNumberCountryCode {
    US("US"),
    CA("CA");

    private final String value;

    PhoneNumberCountryCode(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PhoneNumberCountryCode from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown PhoneNumberCountryCode: " + v);
    }
}
