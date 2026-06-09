package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Action to take when a call is detected to be in voicemail.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = VoicemailActionPrompt.class, name = "prompt"),
        @JsonSubTypes.Type(value = VoicemailActionStaticText.class, name = "static_text"),
        @JsonSubTypes.Type(value = VoicemailActionHangup.class, name = "hangup"),
        @JsonSubTypes.Type(value = VoicemailActionBridgeTransfer.class, name = "bridge_transfer")
})
public sealed interface VoicemailAction
        permits VoicemailActionPrompt, VoicemailActionStaticText,
        VoicemailActionHangup, VoicemailActionBridgeTransfer {
}
