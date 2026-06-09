package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Prohibited agent output topic category. */
public enum GuardrailOutputTopic {
    HARASSMENT("harassment"),
    SELF_HARM("self_harm"),
    SEXUAL_EXPLOITATION("sexual_exploitation"),
    VIOLENCE("violence"),
    DEFENSE_AND_NATIONAL_SECURITY("defense_and_national_security"),
    ILLICIT_AND_HARMFUL_ACTIVITY("illicit_and_harmful_activity"),
    GAMBLING("gambling"),
    REGULATED_PROFESSIONAL_ADVICE("regulated_professional_advice"),
    CHILD_SAFETY_AND_EXPLOITATION("child_safety_and_exploitation");

    private final String value;

    GuardrailOutputTopic(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static GuardrailOutputTopic from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown GuardrailOutputTopic: " + v);
    }
}
