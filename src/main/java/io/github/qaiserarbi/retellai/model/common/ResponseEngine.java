package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * The response engine that powers an agent. Discriminated by the {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ResponseEngineRetellLm.class, name = "retell-llm"),
        @JsonSubTypes.Type(value = ResponseEngineCustomLm.class, name = "custom-llm"),
        @JsonSubTypes.Type(value = ResponseEngineConversationFlow.class, name = "conversation-flow")
})
public sealed interface ResponseEngine
        permits ResponseEngineRetellLm, ResponseEngineCustomLm, ResponseEngineConversationFlow {
}
