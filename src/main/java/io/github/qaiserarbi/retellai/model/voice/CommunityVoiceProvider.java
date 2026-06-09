package io.github.qaiserarbi.retellai.model.voice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Voice provider for community voice add/search operations. */
public enum CommunityVoiceProvider {
    ELEVENLABS("elevenlabs"),
    CARTESIA("cartesia"),
    MINIMAX("minimax"),
    FISH_AUDIO("fish_audio");

    private final String value;

    CommunityVoiceProvider(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static CommunityVoiceProvider from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown CommunityVoiceProvider: " + v);
    }
}
