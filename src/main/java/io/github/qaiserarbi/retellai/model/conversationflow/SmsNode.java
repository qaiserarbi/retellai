package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
// (instruction kept as Object: spec allows NodeInstruction or SmsInstructionTemplate)

/**
 * A node that sends an SMS message.
 *
 * <p>The {@code instruction} is a free-form object because the spec allows either a
 * {@link NodeInstruction} (prompt / static_text) or an {@link SmsInstructionTemplate}.</p>
 *
 * @param id                unique identifier for the node.
 * @param name              optional display name.
 * @param globalNodeSetting optional global node configuration.
 * @param displayPosition   frontend display position.
 * @param modelChoice       model choice override for this node (free-form).
 * @param instruction       the SMS instruction (NodeInstruction or SmsInstructionTemplate shape).
 * @param successEdge       edge taken when the SMS is sent successfully.
 * @param failedEdge        edge taken when the SMS fails to send.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SmsNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        Object instruction,
        NodeEdge successEdge,
        NodeEdge failedEdge
) implements ConversationFlowNode {
}
