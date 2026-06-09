package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Sort order for chat listing by start timestamp. */
public enum ChatSortOrder {
    ASCENDING("ascending"),
    DESCENDING("descending");

    private final String value;

    ChatSortOrder(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatSortOrder from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatSortOrder: " + v);
    }
}
