package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Available LLM models for agents (nullable variant; null is represented by the field being unset). */
public enum NullableLLMModel {
    GPT_4_1("gpt-4.1"),
    GPT_4_1_MINI("gpt-4.1-mini"),
    GPT_4_1_NANO("gpt-4.1-nano"),
    GPT_5("gpt-5"),
    GPT_5_MINI("gpt-5-mini"),
    GPT_5_NANO("gpt-5-nano"),
    GPT_5_1("gpt-5.1"),
    GPT_5_2("gpt-5.2"),
    GPT_5_4("gpt-5.4"),
    GPT_5_4_MINI("gpt-5.4-mini"),
    GPT_5_4_NANO("gpt-5.4-nano"),
    GPT_5_5("gpt-5.5"),
    CLAUDE_4_5_SONNET("claude-4.5-sonnet"),
    CLAUDE_4_6_SONNET("claude-4.6-sonnet"),
    CLAUDE_4_5_HAIKU("claude-4.5-haiku"),
    GEMINI_2_5_FLASH_LITE("gemini-2.5-flash-lite"),
    GEMINI_3_0_FLASH("gemini-3.0-flash"),
    GEMINI_3_1_FLASH_LITE("gemini-3.1-flash-lite");

    private final String value;

    NullableLLMModel(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static NullableLLMModel from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown NullableLLMModel: " + v);
    }
}
