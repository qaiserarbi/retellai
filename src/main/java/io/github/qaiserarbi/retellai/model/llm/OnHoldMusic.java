package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Music to play while the caller is being transferred. */
public enum OnHoldMusic {
    NONE("none"),
    RELAXING_SOUND("relaxing_sound"),
    UPLIFTING_BEATS("uplifting_beats"),
    RINGTONE("ringtone");

    private final String value;

    OnHoldMusic(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static OnHoldMusic from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown OnHoldMusic: " + v);
    }
}
