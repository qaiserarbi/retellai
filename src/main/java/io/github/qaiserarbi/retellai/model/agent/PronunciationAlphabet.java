package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Phonetic alphabet used for a pronunciation entry. */
public enum PronunciationAlphabet {
    IPA("ipa"),
    CMU("cmu");

    private final String value;

    PronunciationAlphabet(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PronunciationAlphabet from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown PronunciationAlphabet: " + v);
    }
}
