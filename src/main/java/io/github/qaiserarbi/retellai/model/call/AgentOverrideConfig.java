package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Per-node/per-call agent behavior overrides such as interruption sensitivity,
 * responsiveness, voice speed, and DTMF interruption handling.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentOverrideConfig(
        Double interruptionSensitivity,
        Double responsiveness,
        Double voiceSpeed,
        Boolean allowDtmfInterruption) {
}
