package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Scoring criteria for a test case definition.
 *
 * @param customConditions   custom scoring conditions
 * @param performanceMetrics performance metric criteria
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ScoringCriteria(
        List<CustomCondition> customConditions,
        List<PerformanceMetricCriteria> performanceMetrics
) {

    /**
     * A single custom scoring condition.
     *
     * @param description description of the condition
     * @param scoreWeight weight for scoring (1-100)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CustomCondition(
            String description,
            Double scoreWeight
    ) {
    }
}
