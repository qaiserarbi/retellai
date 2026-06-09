package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Allowed calling windows in a specific timezone. Each window is a half-open
 * interval [startMin, endMin) in minutes since local midnight. Cross-midnight
 * windows are not allowed.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CallTimeWindow(
        List<TimeWindow> windows,
        String timezone,
        List<DayOfWeek> day) {
}
