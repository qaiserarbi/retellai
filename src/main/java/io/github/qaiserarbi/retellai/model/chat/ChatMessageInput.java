package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;

/**
 * Input message for chat-completion style requests. Same shape as the
 * {@link MessageOrToolCall} transcript entries, except {@code messageId} and
 * {@code createdTimestamp} are optional (the server generates them if omitted).
 *
 * <p>Discriminated by the wire {@code role} field, kept visible so each variant
 * can expose its concrete {@code role} value.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "role", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChatMessageInput.MessageInput.class, name = "agent"),
        @JsonSubTypes.Type(value = ChatMessageInput.MessageInput.class, name = "user"),
        @JsonSubTypes.Type(value = ChatMessageInput.ToolCallInvocationInput.class, name = "tool_call_invocation"),
        @JsonSubTypes.Type(value = ChatMessageInput.ToolCallResultInput.class, name = "tool_call_result"),
        @JsonSubTypes.Type(value = ChatMessageInput.NodeTransitionInput.class, name = "node_transition"),
        @JsonSubTypes.Type(value = ChatMessageInput.StateTransitionInput.class, name = "state_transition"),
        @JsonSubTypes.Type(value = ChatMessageInput.InjectedInput.class, name = "injected"),
        @JsonSubTypes.Type(value = ChatMessageInput.SmsInput.class, name = "sms")
})
public sealed interface ChatMessageInput {

    /** A standard message sent by the agent or the user. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record MessageInput(
            MessageRole role,
            String messageId,
            String content,
            Long createdTimestamp) implements ChatMessageInput {
    }

    /** A tool call invocation input. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record ToolCallInvocationInput(
            MessageRole role,
            String messageId,
            String toolCallId,
            String name,
            String arguments,
            String thoughtSignature,
            Long createdTimestamp) implements ChatMessageInput {
    }

    /** A tool call result input. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record ToolCallResultInput(
            MessageRole role,
            String messageId,
            String toolCallId,
            String content,
            Boolean successful,
            Long createdTimestamp) implements ChatMessageInput {
    }

    /** A node transition input. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record NodeTransitionInput(
            MessageRole role,
            String messageId,
            String formerNodeId,
            String formerNodeName,
            String newNodeId,
            String newNodeName,
            String transitionType,
            Long createdTimestamp) implements ChatMessageInput {
    }

    /** A state transition input. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record StateTransitionInput(
            MessageRole role,
            String messageId,
            String formerStateName,
            String newStateName,
            Long createdTimestamp) implements ChatMessageInput {
    }

    /** An injected-context input. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record InjectedInput(
            MessageRole role,
            String messageId,
            String content,
            Long createdTimestamp) implements ChatMessageInput {
    }

    /** An SMS message input. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record SmsInput(
            MessageRole role,
            String messageId,
            String content,
            List<SmsMultimediaItem> multimedia,
            Long createdTimestamp) implements ChatMessageInput {
    }
}
