package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Transfer option: cold, warm, or agentic warm transfer. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TransferOptionColdTransfer.class, name = "cold_transfer"),
        @JsonSubTypes.Type(value = TransferOptionWarmTransfer.class, name = "warm_transfer"),
        @JsonSubTypes.Type(value = TransferOptionAgenticWarmTransfer.class, name = "agentic_warm_transfer")
})
public sealed interface TransferOption
        permits TransferOptionColdTransfer, TransferOptionWarmTransfer, TransferOptionAgenticWarmTransfer {
}
