package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Warm transfer option.
 *
 * @param showTransfereeAsCaller   if true, show the transferee as the caller (when supported).
 * @param agentDetectionTimeoutMs  time to wait before considering the transfer failed, in milliseconds.
 * @param transferRingDurationMs   override the ring duration for this transfer, in milliseconds.
 * @param onHoldMusic              music to play while the caller is being transferred.
 * @param publicHandoffOption      handoff message said to both parties on success.
 * @param privateHandoffOption     handoff message said only to the receiving agent on connect.
 * @param ivrOption                IVR navigation prompt to run during human detection.
 * @param optOutHumanDetection     if true, do not perform human detection for the transfer.
 * @param enableBridgeAudioCue     whether to play an audio cue when bridging the call.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransferOptionWarmTransfer(
        Boolean showTransfereeAsCaller,
        Double agentDetectionTimeoutMs,
        Integer transferRingDurationMs,
        OnHoldMusic onHoldMusic,
        WarmTransferHandoffOption publicHandoffOption,
        WarmTransferHandoffOption privateHandoffOption,
        WarmTransferPrompt ivrOption,
        Boolean optOutHumanDetection,
        Boolean enableBridgeAudioCue
) implements TransferOption {
}
