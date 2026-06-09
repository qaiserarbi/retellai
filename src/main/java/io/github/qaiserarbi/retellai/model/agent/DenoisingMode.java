package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Audio denoising mode. */
public enum DenoisingMode {
    NO_DENOISE("no-denoise"),
    NOISE_CANCELLATION("noise-cancellation"),
    NOISE_AND_BACKGROUND_SPEECH_CANCELLATION("noise-and-background-speech-cancellation");

    private final String value;

    DenoisingMode(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static DenoisingMode from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown DenoisingMode: " + v);
    }
}
