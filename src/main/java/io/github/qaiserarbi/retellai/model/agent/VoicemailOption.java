package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Voicemail detection option. When set, the call attempts to detect voicemail and
 * applies the configured action.
 *
 * @param action          action to apply when voicemail is detected
 * @param detectionPrompt optional description of what should be treated as voicemail
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record VoicemailOption(
        VoicemailAction action,
        String detectionPrompt
) {
}
