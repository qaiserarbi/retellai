package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Handoff message option for a warm transfer: either a dynamic prompt or a static message. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = WarmTransferPrompt.class, name = "prompt"),
        @JsonSubTypes.Type(value = WarmTransferStaticMessage.class, name = "static_message")
})
public sealed interface WarmTransferHandoffOption
        permits WarmTransferPrompt, WarmTransferStaticMessage {
}
