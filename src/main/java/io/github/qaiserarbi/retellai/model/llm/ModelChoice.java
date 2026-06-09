package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Model choice configuration. Currently only the cascading variant is supported. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModelChoiceCascading.class, name = "cascading")
})
public sealed interface ModelChoice permits ModelChoiceCascading {
}
