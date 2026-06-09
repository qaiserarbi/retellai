package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Voicemail action that speaks a static piece of text.
 *
 * @param text the text to be spoken when the call is detected to be in voicemail
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record VoicemailActionStaticText(String text) implements VoicemailAction {
}
