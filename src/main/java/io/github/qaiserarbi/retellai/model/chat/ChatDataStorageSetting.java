package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Controls what data is stored for a chat agent. */
public enum ChatDataStorageSetting {
    EVERYTHING("everything"),
    EVERYTHING_EXCEPT_PII("everything_except_pii"),
    BASIC_ATTRIBUTES_ONLY("basic_attributes_only");

    private final String value;

    ChatDataStorageSetting(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatDataStorageSetting from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatDataStorageSetting: " + v);
    }
}
