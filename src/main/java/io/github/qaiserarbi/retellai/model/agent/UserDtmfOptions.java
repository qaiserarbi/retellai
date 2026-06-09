package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Options controlling how user DTMF (touch-tone) input is collected.
 *
 * @param digitLimit     max number of digits allowed per turn
 * @param terminationKey single key signalling end of DTMF input
 * @param timeoutMs      time to wait for DTMF input before timing out
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDtmfOptions(
        Integer digitLimit,
        String terminationKey,
        Integer timeoutMs
) {
}
