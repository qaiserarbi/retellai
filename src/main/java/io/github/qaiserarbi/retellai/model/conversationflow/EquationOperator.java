package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Logical operator joining equations in an {@link EquationCondition}.
 */
public enum EquationOperator {
    OR("||"),
    AND("&&");

    private final String value;

    EquationOperator(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static EquationOperator from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown EquationOperator: " + v);
    }
}
