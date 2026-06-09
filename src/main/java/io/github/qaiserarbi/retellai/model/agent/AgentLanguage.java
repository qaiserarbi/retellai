package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

/**
 * Language(s) the agent operates in. Accepts either a single scalar locale (e.g.
 * {@code "en-US"}), the legacy scalar {@code "multi"} for multilingual support, or
 * an array of concrete locale codes for explicit multi-locale selection.
 *
 * @param value the underlying value: a {@code String} locale or a {@code List<String>} of locales
 */
public record AgentLanguage(@JsonValue Object value) {

    @JsonCreator
    public AgentLanguage {
    }

    /** Create a language holder from a single scalar locale or the legacy {@code "multi"} value. */
    public static AgentLanguage of(String locale) {
        return new AgentLanguage(locale);
    }

    /** Create a language holder from an explicit list of concrete locale codes. */
    public static AgentLanguage of(List<String> locales) {
        return new AgentLanguage(locales);
    }
}
