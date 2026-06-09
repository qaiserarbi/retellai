package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * A node that invokes a tool/function.
 *
 * @param id                         unique identifier for the node.
 * @param name                       optional display name.
 * @param globalNodeSetting          optional global node configuration.
 * @param displayPosition            frontend display position.
 * @param modelChoice                model choice override for this node (free-form).
 * @param toolId                     tool id to invoke.
 * @param toolType                   tool type ({@code local} or {@code shared}).
 * @param speakDuringExecution       whether to speak during tool execution.
 * @param instruction                what to say during execution.
 * @param waitForResult              whether to wait for the tool result.
 * @param enableTypingSound          if true, play a typing sound while executing.
 * @param edges                      conditional transition edges.
 * @param elseEdge                   default edge when no condition matches.
 * @param finetuneTransitionExamples transition finetune examples.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FunctionNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        String toolId,
        String toolType,
        Boolean speakDuringExecution,
        NodeInstruction instruction,
        Boolean waitForResult,
        Boolean enableTypingSound,
        List<NodeEdge> edges,
        NodeEdge elseEdge,
        List<NodeFinetuneTransitionExample> finetuneTransitionExamples
) implements ConversationFlowNode {
}
