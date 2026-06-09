package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * A node that references a (local or shared) conversation flow component.
 *
 * <p>Note: this node only carries the common base fields (no {@code model_choice}).</p>
 *
 * @param id                         unique identifier for the node.
 * @param name                       optional display name.
 * @param globalNodeSetting          optional global node configuration.
 * @param displayPosition            frontend display position.
 * @param componentId                the reference id of the component.
 * @param componentType              type of component ({@code local} or {@code shared}).
 * @param edges                      conditional transition edges.
 * @param elseEdge                   default edge when no condition matches.
 * @param finetuneTransitionExamples transition finetune examples.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ComponentNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        String componentId,
        String componentType,
        List<NodeEdge> edges,
        NodeEdge elseEdge,
        List<NodeFinetuneTransitionExample> finetuneTransitionExamples
) implements ConversationFlowNode {
}
