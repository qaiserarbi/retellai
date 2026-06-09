package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * System preset for post-chat analysis (chat agents). Use in {@code post_chat_analysis_data}
 * to override prompts or mark fields optional.
 *
 * @param name              preset identifier for chat agent analysis.
 * @param description       prompt or description for this preset.
 * @param required          if false, this field is optional in the analysis.
 * @param conditionalPrompt optional instruction deciding whether this field needs to be populated.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChatPresetAnalysisData(
        Name name,
        String description,
        Boolean required,
        String conditionalPrompt
) implements PostChatAnalysisData {

    /** Preset identifier for chat agent analysis. */
    public enum Name {
        CHAT_SUMMARY("chat_summary"),
        CHAT_SUCCESSFUL("chat_successful"),
        USER_SENTIMENT("user_sentiment");

        private final String value;

        Name(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static Name from(String v) {
            for (var e : values()) {
                if (e.value.equals(v)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("Unknown Name: " + v);
        }
    }
}
