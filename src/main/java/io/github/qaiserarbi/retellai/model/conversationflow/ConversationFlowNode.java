package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * A node within a conversation flow. Discriminated union keyed on the {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConversationNode.class, name = "conversation"),
        @JsonSubTypes.Type(value = SubagentNode.class, name = "subagent"),
        @JsonSubTypes.Type(value = EndNode.class, name = "end"),
        @JsonSubTypes.Type(value = FunctionNode.class, name = "function"),
        @JsonSubTypes.Type(value = CodeNode.class, name = "code"),
        @JsonSubTypes.Type(value = TransferCallNode.class, name = "transfer_call"),
        @JsonSubTypes.Type(value = PressDigitNode.class, name = "press_digit"),
        @JsonSubTypes.Type(value = BranchNode.class, name = "branch"),
        @JsonSubTypes.Type(value = SmsNode.class, name = "sms"),
        @JsonSubTypes.Type(value = ExtractDynamicVariablesNode.class, name = "extract_dynamic_variables"),
        @JsonSubTypes.Type(value = AgentSwapNode.class, name = "agent_swap"),
        @JsonSubTypes.Type(value = McpNode.class, name = "mcp"),
        @JsonSubTypes.Type(value = ComponentNode.class, name = "component"),
        @JsonSubTypes.Type(value = BridgeTransferNode.class, name = "bridge_transfer"),
        @JsonSubTypes.Type(value = CancelTransferNode.class, name = "cancel_transfer")
})
public sealed interface ConversationFlowNode
        permits ConversationNode, SubagentNode, EndNode, FunctionNode, CodeNode,
        TransferCallNode, PressDigitNode, BranchNode, SmsNode, ExtractDynamicVariablesNode,
        AgentSwapNode, McpNode, ComponentNode, BridgeTransferNode, CancelTransferNode {

    /** @return unique identifier for the node. */
    String id();
}
