package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Voicemail action that bridge-transfers the call when voicemail is detected.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record VoicemailActionBridgeTransfer() implements VoicemailAction {
}
