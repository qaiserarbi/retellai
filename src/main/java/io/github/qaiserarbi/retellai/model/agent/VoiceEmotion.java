package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Emotional tone of the agent's voice. */
public enum VoiceEmotion {
    CALM("calm"),
    SYMPATHETIC("sympathetic"),
    HAPPY("happy"),
    SAD("sad"),
    ANGRY("angry"),
    FEARFUL("fearful"),
    SURPRISED("surprised");

    private final String value;

    VoiceEmotion(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static VoiceEmotion from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown VoiceEmotion: " + v);
    }
}
