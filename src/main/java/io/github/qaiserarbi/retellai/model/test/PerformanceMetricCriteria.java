package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * A performance metric used as scoring criteria for a test case.
 *
 * @param metricType  performance metric type (free-form object)
 * @param op          comparison operator for filtering
 * @param value       value to compare against
 * @param scoreWeight weight for scoring (1-100)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PerformanceMetricCriteria(
        Map<String, Object> metricType,
        Op op,
        Double value,
        Double scoreWeight
) {

    /** Comparison operator for a performance metric criteria. */
    public enum Op {
        GT("gt"), GTE("gte"), GE("ge"), LT("lt"), LTE("lte"), LE("le"), EQ("eq"), NE("ne");

        private final String value;

        Op(String value) {
            this.value = value;
        }

        @com.fasterxml.jackson.annotation.JsonValue
        public String value() {
            return value;
        }

        @com.fasterxml.jackson.annotation.JsonCreator
        public static Op from(String v) {
            for (var e : values()) {
                if (e.value.equals(v)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("Unknown Op: " + v);
        }
    }
}
