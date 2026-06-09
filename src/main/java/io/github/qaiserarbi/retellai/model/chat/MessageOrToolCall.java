package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Transcript entry of a chat woven with tool call invocations and results.
 *
 * <p>The variant is discriminated by the wire {@code role} field. The {@code agent}
 * and {@code user} roles both map to {@link Message}; the remaining roles map to
 * their dedicated record variants. The discriminator is kept visible so each
 * variant can expose its concrete {@code role} value.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "role", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Message.class, name = "agent"),
        @JsonSubTypes.Type(value = Message.class, name = "user"),
        @JsonSubTypes.Type(value = ToolCallInvocationMessage.class, name = "tool_call_invocation"),
        @JsonSubTypes.Type(value = ToolCallResultMessage.class, name = "tool_call_result"),
        @JsonSubTypes.Type(value = NodeTransitionMessage.class, name = "node_transition"),
        @JsonSubTypes.Type(value = StateTransitionMessage.class, name = "state_transition"),
        @JsonSubTypes.Type(value = InjectedMessage.class, name = "injected"),
        @JsonSubTypes.Type(value = SmsMessage.class, name = "sms")
})
public sealed interface MessageOrToolCall
        permits Message, ToolCallInvocationMessage, ToolCallResultMessage,
        NodeTransitionMessage, StateTransitionMessage, InjectedMessage, SmsMessage {
}
