package io.github.qaiserarbi.retellai.model.phone;

import java.util.List;

/**
 * A Retell phone number.
 *
 * @param phoneNumber                 E.164 format of the number, used as the unique identifier
 * @param phoneNumberType             type of the phone number
 * @param phoneNumberPretty           pretty printed phone number, for reference
 * @param allowedInboundCountryList   ISO 3166-1 alpha-2 country codes from which inbound calls are allowed
 * @param allowedOutboundCountryList  ISO 3166-1 alpha-2 country codes to which outbound calls are allowed
 * @param areaCode                    area code of the number
 * @param inboundAgents               inbound agents bound to the number with weights
 * @param outboundAgents              outbound agents bound to the number with weights
 * @param inboundSmsAgents            inbound SMS agents bound to the number with weights
 * @param outboundSmsAgents           outbound SMS agents bound to the number with weights
 * @param nickname                    nickname of the number, for reference
 * @param inboundWebhookUrl           webhook URL invoked for inbound calls
 * @param inboundSmsWebhookUrl        webhook URL invoked for inbound SMS
 * @param lastModificationTimestamp   last modification timestamp (milliseconds since epoch)
 * @param sipOutboundTrunkConfig      SIP outbound trunk configuration
 * @param fallbackNumber              fallback number used when inbound concurrency is reached
 */
public record PhoneNumberResponse(
        String phoneNumber,
        PhoneNumberType phoneNumberType,
        String phoneNumberPretty,
        List<String> allowedInboundCountryList,
        List<String> allowedOutboundCountryList,
        Integer areaCode,
        List<AgentWeight> inboundAgents,
        List<AgentWeight> outboundAgents,
        List<AgentWeight> inboundSmsAgents,
        List<AgentWeight> outboundSmsAgents,
        String nickname,
        String inboundWebhookUrl,
        String inboundSmsWebhookUrl,
        Long lastModificationTimestamp,
        SipOutboundTrunkConfig sipOutboundTrunkConfig,
        String fallbackNumber
) {}
