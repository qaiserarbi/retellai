package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Sort order for list responses, by {@code start_timestamp}. */
public enum SortOrder {
    ASCENDING("ascending"),
    DESCENDING("descending");

    private final String value;

    SortOrder(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static SortOrder from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown SortOrder: " + v);
    }
}
