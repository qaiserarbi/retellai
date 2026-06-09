package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Underlying speech-to-speech model (null represented by the field being unset). */
public enum S2sModel {
    GPT_REALTIME_2("gpt-realtime-2"),
    GPT_REALTIME_1_5("gpt-realtime-1.5"),
    GPT_REALTIME("gpt-realtime"),
    GPT_REALTIME_MINI("gpt-realtime-mini");

    private final String value;

    S2sModel(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static S2sModel from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown S2sModel: " + v);
    }
}
