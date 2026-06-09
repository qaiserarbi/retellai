package io.github.qaiserarbi.retellai.model.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Request to update an existing phone number.
 *
 * @param inboundAgents               inbound agents to bind to the number with weights
 * @param outboundAgents              outbound agents to bind to the number with weights
 * @param inboundSmsAgents            inbound SMS agents to bind to the number with weights
 * @param outboundSmsAgents           outbound SMS agents to bind to the number with weights
 * @param nickname                    nickname of the number, for reference
 * @param inboundWebhookUrl           webhook URL invoked for inbound calls
 * @param inboundSmsWebhookUrl        webhook URL invoked for inbound SMS
 * @param allowedInboundCountryList   ISO 3166-1 alpha-2 country codes from which inbound calls are allowed
 * @param allowedOutboundCountryList  ISO 3166-1 alpha-2 country codes to which outbound calls are allowed
 * @param terminationUri              the termination URI to update for the SIP trunk
 * @param authUsername                the username used for SIP trunk authentication
 * @param authPassword                the password used for SIP trunk authentication
 * @param transport                   outbound transport protocol ("TLS", "TCP" or "UDP")
 * @param fallbackNumber              fallback number used when inbound concurrency is reached
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdatePhoneNumberRequest(
        List<AgentWeight> inboundAgents,
        List<AgentWeight> outboundAgents,
        List<AgentWeight> inboundSmsAgents,
        List<AgentWeight> outboundSmsAgents,
        String nickname,
        String inboundWebhookUrl,
        String inboundSmsWebhookUrl,
        List<String> allowedInboundCountryList,
        List<String> allowedOutboundCountryList,
        String terminationUri,
        String authUsername,
        String authPassword,
        String transport,
        String fallbackNumber
) {}
