package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Sentiment of the user in the call. */
public enum UserSentiment {
    NEGATIVE("Negative"),
    POSITIVE("Positive"),
    NEUTRAL("Neutral"),
    UNKNOWN("Unknown");

    private final String value;

    UserSentiment(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static UserSentiment from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown UserSentiment: " + v);
    }
}
