package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Post-call analysis item (custom data or voice preset). Use for voice agent
 * {@code post_call_analysis_data}; validates only call presets (call_summary,
 * call_successful, user_sentiment). Discriminated by the {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StringAnalysisData.class, name = "string"),
        @JsonSubTypes.Type(value = EnumAnalysisData.class, name = "enum"),
        @JsonSubTypes.Type(value = BooleanAnalysisData.class, name = "boolean"),
        @JsonSubTypes.Type(value = NumberAnalysisData.class, name = "number"),
        @JsonSubTypes.Type(value = CallPresetAnalysisData.class, name = "system-presets")
})
public sealed interface PostCallAnalysisData
        permits StringAnalysisData, EnumAnalysisData, BooleanAnalysisData, NumberAnalysisData,
        CallPresetAnalysisData {
}
