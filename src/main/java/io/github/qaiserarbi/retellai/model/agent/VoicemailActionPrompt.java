package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Voicemail action that generates spoken text from a prompt.
 *
 * @param text the prompt used to generate the text to be spoken in voicemail
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record VoicemailActionPrompt(String text) implements VoicemailAction {
}
