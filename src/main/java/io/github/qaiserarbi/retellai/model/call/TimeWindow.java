package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A half-open time interval [start, end) in minutes since local midnight.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TimeWindow(
        Double start,
        Double end) {
}
