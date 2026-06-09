package io.github.qaiserarbi.retellai.model.voice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Voice provider to use for cloning. */
public enum CloneVoiceProvider {
    ELEVENLABS("elevenlabs"),
    CARTESIA("cartesia"),
    MINIMAX("minimax"),
    FISH_AUDIO("fish_audio"),
    PLATFORM("platform");

    private final String value;

    CloneVoiceProvider(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static CloneVoiceProvider from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown CloneVoiceProvider: " + v);
    }
}
