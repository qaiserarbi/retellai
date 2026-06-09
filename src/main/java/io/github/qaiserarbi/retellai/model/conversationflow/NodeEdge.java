package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * An edge connecting one node to another, gated by a {@link TransitionCondition}.
 *
 * <p>This type also represents the specialized edges in the spec (always, else, skip-response,
 * transfer-failed, SMS success/failed), which share the same structure but constrain the
 * transition condition prompt to a fixed value.</p>
 *
 * @param id                  unique identifier for the edge.
 * @param transitionCondition the condition that triggers this edge.
 * @param destinationNodeId   the id of the destination node.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record NodeEdge(
        String id,
        TransitionCondition transitionCondition,
        String destinationNodeId
) {
}
