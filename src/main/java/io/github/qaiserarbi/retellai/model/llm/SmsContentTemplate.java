package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A template-based SMS content.
 *
 * @param template the template to use for the SMS content.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SmsContentTemplate(
        Template template
) implements SmsContent {

    /** Available SMS content templates. */
    public enum Template {
        INFO_COLLECTION("info_collection");

        private final String value;

        Template(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static Template from(String v) {
            for (var e : values()) {
                if (e.value.equals(v)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("Unknown Template: " + v);
        }
    }
}
