package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A custom metric used as scoring criteria for a test case.
 *
 * @param name        name of the custom metric
 * @param description description of the custom metric
 * @param scoreWeight weight for scoring (1-100)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CustomMetricCriteria(
        String name,
        String description,
        Double scoreWeight
) {
}
