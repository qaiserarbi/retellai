package io.github.qaiserarbi.retellai.model.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Request to create (purchase) a new phone number.
 *
 * @param inboundAgents               inbound agents to bind to the number with weights
 * @param outboundAgents              outbound agents to bind to the number with weights
 * @param areaCode                    area code of the number to obtain (3 digit integer)
 * @param nickname                    nickname of the number, for reference
 * @param inboundWebhookUrl           webhook URL invoked for inbound calls
 * @param allowedInboundCountryList   ISO 3166-1 alpha-2 country codes from which inbound calls are allowed
 * @param allowedOutboundCountryList  ISO 3166-1 alpha-2 country codes to which outbound calls are allowed
 * @param numberProvider              the provider to purchase the phone number from (default twilio)
 * @param countryCode                 the country code of the number to purchase (default US)
 * @param tollFree                    whether to purchase a toll-free number
 * @param phoneNumber                 specific number to purchase in E.164 format
 * @param transport                   outbound transport protocol ("TLS", "TCP" or "UDP")
 * @param fallbackNumber              fallback number used when inbound concurrency is reached
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreatePhoneNumberRequest(
        List<AgentWeight> inboundAgents,
        List<AgentWeight> outboundAgents,
        Integer areaCode,
        String nickname,
        String inboundWebhookUrl,
        List<String> allowedInboundCountryList,
        List<String> allowedOutboundCountryList,
        NumberProvider numberProvider,
        PhoneNumberCountryCode countryCode,
        Boolean tollFree,
        String phoneNumber,
        String transport,
        String fallbackNumber
) {}
