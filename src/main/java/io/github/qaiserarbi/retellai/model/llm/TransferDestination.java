package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Destination of a transfer: either a predefined number or one inferred at runtime. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TransferDestinationPredefined.class, name = "predefined"),
        @JsonSubTypes.Type(value = TransferDestinationInferred.class, name = "inferred")
})
public sealed interface TransferDestination
        permits TransferDestinationPredefined, TransferDestinationInferred {
}
