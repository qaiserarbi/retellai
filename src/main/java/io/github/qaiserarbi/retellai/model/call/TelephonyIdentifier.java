package io.github.qaiserarbi.retellai.model.call;

/**
 * Telephony identifier of the call, populated when available. Tracking purposes
 * only.
 */
public record TelephonyIdentifier(
        String twilioCallSid) {
}
