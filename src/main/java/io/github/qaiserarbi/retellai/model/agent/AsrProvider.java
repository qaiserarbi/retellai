package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** ASR (speech-to-text) provider name. */
public enum AsrProvider {
    AZURE("azure"),
    DEEPGRAM("deepgram"),
    SONIOX("soniox");

    private final String value;

    AsrProvider(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static AsrProvider from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown AsrProvider: " + v);
    }
}
