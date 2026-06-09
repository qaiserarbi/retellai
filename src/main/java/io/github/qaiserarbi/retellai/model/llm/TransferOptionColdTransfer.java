package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Cold transfer option.
 *
 * @param showTransfereeAsCaller if true, show the transferee as the caller (when supported).
 * @param coldTransferMode       the mode of the cold transfer (sip_refer or sip_invite).
 * @param transferRingDurationMs override the ring duration for this transfer, in milliseconds.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransferOptionColdTransfer(
        Boolean showTransfereeAsCaller,
        ColdTransferMode coldTransferMode,
        Integer transferRingDurationMs
) implements TransferOption {
}
