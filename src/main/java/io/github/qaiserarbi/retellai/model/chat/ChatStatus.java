package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Status of a chat session. */
public enum ChatStatus {
    ONGOING("ongoing"),
    ENDED("ended"),
    ERROR("error");

    private final String value;

    ChatStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatStatus from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatStatus: " + v);
    }
}
