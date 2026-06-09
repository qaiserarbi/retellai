package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * A conversation node where the agent converses with the user following an instruction.
 *
 * @param id                          unique identifier for the node.
 * @param name                        optional display name.
 * @param globalNodeSetting           optional global node configuration.
 * @param displayPosition             frontend display position.
 * @param modelChoice                 model choice override for this node (free-form).
 * @param interruptionSensitivity     interruption sensitivity override (0-1).
 * @param responsiveness              responsiveness override (0-1).
 * @param voiceSpeed                  voice speed override (0.5-2).
 * @param allowDtmfInterruption       overrides agent-level allow_dtmf_interruption for this node.
 * @param instruction                 the node instruction.
 * @param skipResponseEdge            edge taken to skip a response.
 * @param alwaysEdge                  edge always taken (prompt "Always").
 * @param edges                       conditional transition edges.
 * @param elseEdge                    default edge when no condition matches.
 * @param finetuneConversationExamples conversation finetune examples.
 * @param finetuneTransitionExamples  transition finetune examples.
 * @param knowledgeBaseIds            knowledge base ids for RAG.
 * @param kbConfig                    node-level knowledge base configuration.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConversationNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        Double interruptionSensitivity,
        Double responsiveness,
        Double voiceSpeed,
        Boolean allowDtmfInterruption,
        NodeInstruction instruction,
        NodeEdge skipResponseEdge,
        NodeEdge alwaysEdge,
        List<NodeEdge> edges,
        NodeEdge elseEdge,
        List<NodeFinetuneConversationExample> finetuneConversationExamples,
        List<NodeFinetuneTransitionExample> finetuneTransitionExamples,
        List<String> knowledgeBaseIds,
        KbConfig kbConfig
) implements ConversationFlowNode {
}
