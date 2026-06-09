package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Sentiment of the user in the chat. */
public enum ChatUserSentiment {
    NEGATIVE("Negative"),
    POSITIVE("Positive"),
    NEUTRAL("Neutral"),
    UNKNOWN("Unknown");

    private final String value;

    ChatUserSentiment(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatUserSentiment from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatUserSentiment: " + v);
    }
}
