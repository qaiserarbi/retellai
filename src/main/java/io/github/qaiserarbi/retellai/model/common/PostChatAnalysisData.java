package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Post-chat analysis item (custom data or chat preset). Use for chat agent
 * {@code post_chat_analysis_data}; validates only chat presets (chat_summary,
 * chat_successful, user_sentiment). Discriminated by the {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StringAnalysisData.class, name = "string"),
        @JsonSubTypes.Type(value = EnumAnalysisData.class, name = "enum"),
        @JsonSubTypes.Type(value = BooleanAnalysisData.class, name = "boolean"),
        @JsonSubTypes.Type(value = NumberAnalysisData.class, name = "number"),
        @JsonSubTypes.Type(value = ChatPresetAnalysisData.class, name = "system-presets")
})
public sealed interface PostChatAnalysisData
        permits StringAnalysisData, EnumAnalysisData, BooleanAnalysisData, NumberAnalysisData,
        ChatPresetAnalysisData {
}
