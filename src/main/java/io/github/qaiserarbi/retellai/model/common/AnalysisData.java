package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * A custom analysis data field to extract from a call or chat. Discriminated by the
 * {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StringAnalysisData.class, name = "string"),
        @JsonSubTypes.Type(value = EnumAnalysisData.class, name = "enum"),
        @JsonSubTypes.Type(value = BooleanAnalysisData.class, name = "boolean"),
        @JsonSubTypes.Type(value = NumberAnalysisData.class, name = "number")
})
public sealed interface AnalysisData
        permits StringAnalysisData, EnumAnalysisData, BooleanAnalysisData, NumberAnalysisData {
}
