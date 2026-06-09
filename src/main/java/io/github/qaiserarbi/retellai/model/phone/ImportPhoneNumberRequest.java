package io.github.qaiserarbi.retellai.model.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Request to import an existing phone number from a SIP trunk.
 *
 * @param phoneNumber                 the number to import in E.164 format (unique identifier)
 * @param ignoreE164Validation        if true, E.164 validation is skipped (default true)
 * @param terminationUri              the termination URI uniquely identifying the elastic SIP trunk
 * @param sipTrunkAuthUsername        the username used for SIP trunk authentication
 * @param sipTrunkAuthPassword        the password used for SIP trunk authentication
 * @param inboundAgents               inbound agents to bind to the number with weights
 * @param outboundAgents              outbound agents to bind to the number with weights
 * @param nickname                    nickname of the number, for reference
 * @param inboundWebhookUrl           webhook URL invoked for inbound calls
 * @param allowedInboundCountryList   ISO 3166-1 alpha-2 country codes from which inbound calls are allowed
 * @param allowedOutboundCountryList  ISO 3166-1 alpha-2 country codes to which outbound calls are allowed
 * @param transport                   outbound transport protocol ("TLS", "TCP" or "UDP")
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ImportPhoneNumberRequest(
        String phoneNumber,
        Boolean ignoreE164Validation,
        String terminationUri,
        String sipTrunkAuthUsername,
        String sipTrunkAuthPassword,
        List<AgentWeight> inboundAgents,
        List<AgentWeight> outboundAgents,
        String nickname,
        String inboundWebhookUrl,
        List<String> allowedInboundCountryList,
        List<String> allowedOutboundCountryList,
        String transport
) {}
