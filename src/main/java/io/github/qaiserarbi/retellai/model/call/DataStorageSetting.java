package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Data storage setting for a call. */
public enum DataStorageSetting {
    EVERYTHING("everything"),
    EVERYTHING_EXCEPT_PII("everything_except_pii"),
    BASIC_ATTRIBUTES_ONLY("basic_attributes_only");

    private final String value;

    DataStorageSetting(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static DataStorageSetting from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown DataStorageSetting: " + v);
    }
}
