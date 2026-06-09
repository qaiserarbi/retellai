package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Ambient environment sound added to the call. */
public enum AmbientSound {
    COFFEE_SHOP("coffee-shop"),
    CONVENTION_HALL("convention-hall"),
    SUMMER_OUTDOOR("summer-outdoor"),
    MOUNTAIN_OUTDOOR("mountain-outdoor"),
    STATIC_NOISE("static-noise"),
    CALL_CENTER("call-center");

    private final String value;

    AmbientSound(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static AmbientSound from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown AmbientSound: " + v);
    }
}
