package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * A node that cancels a warm transfer and ends the transfer agent call.
 *
 * @param id                   unique identifier for the node.
 * @param name                 optional display name.
 * @param globalNodeSetting    optional global node configuration.
 * @param displayPosition      frontend display position.
 * @param modelChoice          model choice override for this node (free-form).
 * @param speakDuringExecution if true, speaks during execution.
 * @param instruction          what to say while cancelling (used when speaking during execution).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CancelTransferNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        Boolean speakDuringExecution,
        NodeInstruction instruction
) implements ConversationFlowNode {
}
