package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Agentic warm transfer option.
 *
 * @param showTransfereeAsCaller  if true, show the transferee as the caller (when supported).
 * @param onHoldMusic             music to play while the caller is being transferred.
 * @param transferRingDurationMs  override the ring duration for this transfer, in milliseconds.
 * @param publicHandoffOption     handoff message said to both parties on success.
 * @param agenticTransferConfig   configuration for the agentic warm transfer.
 * @param enableBridgeAudioCue    whether to play an audio cue when bridging the call.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransferOptionAgenticWarmTransfer(
        Boolean showTransfereeAsCaller,
        OnHoldMusic onHoldMusic,
        Integer transferRingDurationMs,
        WarmTransferHandoffOption publicHandoffOption,
        AgenticTransferConfig agenticTransferConfig,
        Boolean enableBridgeAudioCue
) implements TransferOption {
}
