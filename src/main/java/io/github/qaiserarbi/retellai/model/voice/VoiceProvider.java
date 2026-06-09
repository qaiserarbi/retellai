package io.github.qaiserarbi.retellai.model.voice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Provider of a voice. */
public enum VoiceProvider {
    ELEVENLABS("elevenlabs"),
    OPENAI("openai"),
    CARTESIA("cartesia"),
    MINIMAX("minimax"),
    FISH_AUDIO("fish_audio"),
    PLATFORM("platform");

    private final String value;

    VoiceProvider(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static VoiceProvider from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown VoiceProvider: " + v);
    }
}
