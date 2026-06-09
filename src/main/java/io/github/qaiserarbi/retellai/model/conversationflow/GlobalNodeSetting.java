package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Settings that turn a node into a global node, reachable from anywhere given the condition.
 *
 * @param condition               condition for global node activation; cannot be empty.
 * @param goBackConditions        conditions for global node "go back" (no destination node id).
 * @param coolDown                the same global node won't be triggered again within the next
 *                                N node transitions.
 * @param positiveFinetuneExamples examples that should transition to this node.
 * @param negativeFinetuneExamples examples that should not transition to this node.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record GlobalNodeSetting(
        String condition,
        List<NodeEdge> goBackConditions,
        Double coolDown,
        List<GlobalNodeFinetuneTransitionExample> positiveFinetuneExamples,
        List<GlobalNodeFinetuneTransitionExample> negativeFinetuneExamples
) {
}
