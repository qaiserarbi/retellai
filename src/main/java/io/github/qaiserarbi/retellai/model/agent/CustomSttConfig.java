package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Custom STT configuration. Only used when {@code sttMode} is set to custom.
 *
 * @param provider      the STT provider to use
 * @param endpointingMs endpointing timeout in milliseconds
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CustomSttConfig(
        AsrProvider provider,
        Integer endpointingMs
) {
}
