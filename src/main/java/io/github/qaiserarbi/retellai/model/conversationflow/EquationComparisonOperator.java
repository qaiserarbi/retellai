package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Comparison operator used within an {@link Equation}.
 */
public enum EquationComparisonOperator {
    EQUALS("=="),
    NOT_EQUALS("!="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUALS(">="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUALS("<="),
    CONTAINS("contains"),
    NOT_CONTAINS("not_contains"),
    EXISTS("exists"),
    NOT_EXIST("not_exist");

    private final String value;

    EquationComparisonOperator(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static EquationComparisonOperator from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown EquationComparisonOperator: " + v);
    }
}
