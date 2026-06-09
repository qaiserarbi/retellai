package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Transition condition for a {@link NodeEdge}. Discriminated by the {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PromptCondition.class, name = "prompt"),
        @JsonSubTypes.Type(value = EquationCondition.class, name = "equation")
})
public sealed interface TransitionCondition
        permits PromptCondition, EquationCondition {
}
