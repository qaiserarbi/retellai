package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Type of a chat. */
public enum ChatType {
    API_CHAT("api_chat"),
    SMS_CHAT("sms_chat");

    private final String value;

    ChatType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatType from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatType: " + v);
    }
}
