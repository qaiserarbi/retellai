package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.Map;

/**
 * A node that swaps the active agent for another agent.
 *
 * @param id                       unique identifier for the node.
 * @param name                     optional display name.
 * @param globalNodeSetting        optional global node configuration.
 * @param displayPosition          frontend display position.
 * @param modelChoice              model choice override for this node (free-form).
 * @param agentId                  the id of the agent to swap to.
 * @param agentVersion             the version of the agent to swap to (latest if unset).
 * @param postCallAnalysisSetting  post-call analysis setting for the swap.
 * @param webhookSetting           webhook setting for the swap (defaults to only source).
 * @param keepCurrentVoice         if true, keep the current voice when swapping.
 * @param keepCurrentLanguage      if true, keep the current language when swapping.
 * @param edge                     edge taken when the agent swap fails.
 * @param speakDuringExecution     if true, speaks during execution.
 * @param instruction              what to say while swapping (used when speaking during
 *                                 execution).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentSwapNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        String agentId,
        AgentVersionReference agentVersion,
        PostCallAnalysisSetting postCallAnalysisSetting,
        AgentSwapWebhookSetting webhookSetting,
        Boolean keepCurrentVoice,
        Boolean keepCurrentLanguage,
        NodeEdge edge,
        Boolean speakDuringExecution,
        NodeInstruction instruction
) implements ConversationFlowNode {
}
