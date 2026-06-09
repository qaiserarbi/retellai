package io.github.qaiserarbi.retellai.model.voice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Gender of a voice. */
public enum VoiceGender {
    MALE("male"),
    FEMALE("female");

    private final String value;

    VoiceGender(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static VoiceGender from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown VoiceGender: " + v);
    }
}
