package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A predefined transfer destination.
 *
 * @param number    the number to transfer to in E.164 format or a dynamic variable.
 * @param extension extension digits to dial after the main number connects, sent via DTMF.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransferDestinationPredefined(
        String number,
        String extension
) implements TransferDestination {
}
