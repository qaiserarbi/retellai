package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * An edge defining how and to which state a transition can occur from a given state.
 *
 * @param destinationStateName the destination state name when transitioning via this edge.
 * @param description          describes the transition and the criteria for it to happen.
 * @param parameters           parameters to extract when the transition occurs.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StateEdge(
        String destinationStateName,
        String description,
        ToolParameter parameters
) {
}
