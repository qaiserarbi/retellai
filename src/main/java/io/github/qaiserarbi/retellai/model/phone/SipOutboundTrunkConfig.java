package io.github.qaiserarbi.retellai.model.phone;

/**
 * SIP outbound trunk configuration for a phone number.
 *
 * @param terminationUri the termination URI for the SIP trunk
 * @param authUsername   the username used for authenticating the SIP trunk
 * @param transport      outbound transport protocol ("TLS", "TCP" or "UDP")
 */
public record SipOutboundTrunkConfig(
        String terminationUri,
        String authUsername,
        String transport
) {}
