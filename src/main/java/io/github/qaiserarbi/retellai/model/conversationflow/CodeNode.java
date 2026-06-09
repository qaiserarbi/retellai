package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * A node that runs JavaScript code in a sandbox.
 *
 * @param id                         unique identifier for the node.
 * @param name                       optional display name.
 * @param globalNodeSetting          optional global node configuration.
 * @param displayPosition            frontend display position.
 * @param modelChoice                model choice override for this node (free-form).
 * @param code                       JavaScript code to execute (max 20000 chars).
 * @param timeoutMs                  max execution time in milliseconds (5000-60000).
 * @param responseVariables          mapping of variable names to JSON paths in the result.
 * @param speakDuringExecution       whether to speak during code execution.
 * @param instruction                what to say during execution.
 * @param waitForResult              whether to wait for the execution result.
 * @param enableTypingSound          if true, play a typing sound while executing.
 * @param edges                      conditional transition edges.
 * @param elseEdge                   default edge when no condition matches.
 * @param finetuneTransitionExamples transition finetune examples.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CodeNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        String code,
        Integer timeoutMs,
        Map<String, String> responseVariables,
        Boolean speakDuringExecution,
        NodeInstruction instruction,
        Boolean waitForResult,
        Boolean enableTypingSound,
        List<NodeEdge> edges,
        NodeEdge elseEdge,
        List<NodeFinetuneTransitionExample> finetuneTransitionExamples
) implements ConversationFlowNode {
}
