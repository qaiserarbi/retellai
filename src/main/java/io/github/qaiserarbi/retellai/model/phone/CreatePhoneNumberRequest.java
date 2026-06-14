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
) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreatePhoneNumberRequest}. */
    public static final class Builder {
        private List<AgentWeight> inboundAgents;
        private List<AgentWeight> outboundAgents;
        private Integer areaCode;
        private String nickname;
        private String inboundWebhookUrl;
        private List<String> allowedInboundCountryList;
        private List<String> allowedOutboundCountryList;
        private NumberProvider numberProvider;
        private PhoneNumberCountryCode countryCode;
        private Boolean tollFree;
        private String phoneNumber;
        private String transport;
        private String fallbackNumber;

        private Builder() {
        }

        public Builder inboundAgents(List<AgentWeight> inboundAgents) {
            this.inboundAgents = inboundAgents;
            return this;
        }

        public Builder outboundAgents(List<AgentWeight> outboundAgents) {
            this.outboundAgents = outboundAgents;
            return this;
        }

        public Builder areaCode(Integer areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder inboundWebhookUrl(String inboundWebhookUrl) {
            this.inboundWebhookUrl = inboundWebhookUrl;
            return this;
        }

        public Builder allowedInboundCountryList(List<String> allowedInboundCountryList) {
            this.allowedInboundCountryList = allowedInboundCountryList;
            return this;
        }

        public Builder allowedOutboundCountryList(List<String> allowedOutboundCountryList) {
            this.allowedOutboundCountryList = allowedOutboundCountryList;
            return this;
        }

        public Builder numberProvider(NumberProvider numberProvider) {
            this.numberProvider = numberProvider;
            return this;
        }

        public Builder countryCode(PhoneNumberCountryCode countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder tollFree(Boolean tollFree) {
            this.tollFree = tollFree;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder transport(String transport) {
            this.transport = transport;
            return this;
        }

        public Builder fallbackNumber(String fallbackNumber) {
            this.fallbackNumber = fallbackNumber;
            return this;
        }

        public CreatePhoneNumberRequest build() {
            return new CreatePhoneNumberRequest(inboundAgents, outboundAgents, areaCode, nickname, inboundWebhookUrl, allowedInboundCountryList, allowedOutboundCountryList, numberProvider, countryCode, tollFree, phoneNumber, transport, fallbackNumber);
        }
    }
}
