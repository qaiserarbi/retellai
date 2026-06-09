package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * A branch node that routes purely based on edge conditions (no instruction).
 *
 * @param id                         unique identifier for the node.
 * @param name                       optional display name.
 * @param globalNodeSetting          optional global node configuration.
 * @param displayPosition            frontend display position.
 * @param modelChoice                model choice override for this node (free-form).
 * @param edges                      conditional transition edges.
 * @param elseEdge                   default edge when no condition matches.
 * @param finetuneTransitionExamples transition finetune examples.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BranchNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        List<NodeEdge> edges,
        NodeEdge elseEdge,
        List<NodeFinetuneTransitionExample> finetuneTransitionExamples
) implements ConversationFlowNode {
}
