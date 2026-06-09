package io.github.qaiserarbi.retellai.model.chat;

/**
 * A node transition woven into the chat transcript.
 *
 * @param role             discriminator role ({@code node_transition}).
 * @param messageId        unique id of the message.
 * @param formerNodeId     former node id.
 * @param formerNodeName   former node name.
 * @param newNodeId        new node id.
 * @param newNodeName      new node name.
 * @param transitionType   how this node was reached ({@code global}, {@code global_go_back},
 *                         {@code interrupt_go_back}, or {@code normal}).
 * @param createdTimestamp create timestamp (milliseconds since epoch) of the message.
 */
public record NodeTransitionMessage(
        MessageRole role,
        String messageId,
        String formerNodeId,
        String formerNodeName,
        String newNodeId,
        String newNodeName,
        String transitionType,
        Long createdTimestamp) implements MessageOrToolCall {
}
