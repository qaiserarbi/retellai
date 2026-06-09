package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AnalysisData;
import java.util.List;
import java.util.Map;

/**
 * A node that extracts dynamic variables from the conversation.
 *
 * @param id                         unique identifier for the node.
 * @param name                       optional display name.
 * @param globalNodeSetting          optional global node configuration.
 * @param displayPosition            frontend display position.
 * @param modelChoice                model choice override for this node (free-form).
 * @param variables                  the variables to extract.
 * @param enableTypingSound          if true, play a typing sound while extracting.
 * @param edges                      conditional transition edges.
 * @param elseEdge                   default edge when no condition matches.
 * @param finetuneTransitionExamples transition finetune examples.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExtractDynamicVariablesNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        List<AnalysisData> variables,
        Boolean enableTypingSound,
        List<NodeEdge> edges,
        NodeEdge elseEdge,
        List<NodeFinetuneTransitionExample> finetuneTransitionExamples
) implements ConversationFlowNode {
}
