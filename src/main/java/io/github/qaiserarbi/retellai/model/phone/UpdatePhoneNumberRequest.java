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
) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link UpdatePhoneNumberRequest}. */
    public static final class Builder {
        private List<AgentWeight> inboundAgents;
        private List<AgentWeight> outboundAgents;
        private List<AgentWeight> inboundSmsAgents;
        private List<AgentWeight> outboundSmsAgents;
        private String nickname;
        private String inboundWebhookUrl;
        private String inboundSmsWebhookUrl;
        private List<String> allowedInboundCountryList;
        private List<String> allowedOutboundCountryList;
        private String terminationUri;
        private String authUsername;
        private String authPassword;
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

        public Builder inboundSmsAgents(List<AgentWeight> inboundSmsAgents) {
            this.inboundSmsAgents = inboundSmsAgents;
            return this;
        }

        public Builder outboundSmsAgents(List<AgentWeight> outboundSmsAgents) {
            this.outboundSmsAgents = outboundSmsAgents;
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

        public Builder inboundSmsWebhookUrl(String inboundSmsWebhookUrl) {
            this.inboundSmsWebhookUrl = inboundSmsWebhookUrl;
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

        public Builder terminationUri(String terminationUri) {
            this.terminationUri = terminationUri;
            return this;
        }

        public Builder authUsername(String authUsername) {
            this.authUsername = authUsername;
            return this;
        }

        public Builder authPassword(String authPassword) {
            this.authPassword = authPassword;
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

        public UpdatePhoneNumberRequest build() {
            return new UpdatePhoneNumberRequest(inboundAgents, outboundAgents, inboundSmsAgents, outboundSmsAgents, nickname, inboundWebhookUrl, inboundSmsWebhookUrl, allowedInboundCountryList, allowedOutboundCountryList, terminationUri, authUsername, authPassword, transport, fallbackNumber);
        }
    }
}
