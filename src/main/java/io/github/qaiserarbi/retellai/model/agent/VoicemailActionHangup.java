package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Voicemail action that hangs up the call when voicemail is detected.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record VoicemailActionHangup() implements VoicemailAction {
}
