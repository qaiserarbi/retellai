package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Calls Per Second (CPS) configuration for different telephony providers.
 *
 * @param twilio CPS limit for Twilio provider (1-5)
 * @param telnyx CPS limit for Telnyx provider (1-16)
 * @param custom CPS limit for custom provider (1-150)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CpsConfig(
        Integer twilio,
        Integer telnyx,
        Integer custom
) {
}
