package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * A node that transfers the call to another destination.
 *
 * @param id                   unique identifier for the node.
 * @param name                 optional display name.
 * @param globalNodeSetting    optional global node configuration.
 * @param displayPosition      frontend display position.
 * @param modelChoice          model choice override for this node (free-form).
 * @param transferDestination  the transfer destination (free-form).
 * @param ignoreE164Validation if true, skip E.164 validation (custom telephony only).
 * @param customSipHeaders     custom SIP headers for the transfer.
 * @param transferOption       the transfer option (free-form).
 * @param edge                 edge taken when the transfer fails.
 * @param speakDuringExecution if true, speaks during execution.
 * @param instruction          what to say while transferring (used when speaking during
 *                             execution).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransferCallNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        Map<String, Object> transferDestination,
        Boolean ignoreE164Validation,
        Map<String, String> customSipHeaders,
        Map<String, Object> transferOption,
        NodeEdge edge,
        Boolean speakDuringExecution,
        NodeInstruction instruction
) implements ConversationFlowNode {
}
