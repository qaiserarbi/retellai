package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Instruction for a conversation flow node. Discriminated by the {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NodeInstructionPrompt.class, name = "prompt"),
        @JsonSubTypes.Type(value = NodeInstructionStaticText.class, name = "static_text")
})
public sealed interface NodeInstruction
        permits NodeInstructionPrompt, NodeInstructionStaticText {
}
