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
) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link ImportPhoneNumberRequest}. */
    public static final class Builder {
        private String phoneNumber;
        private Boolean ignoreE164Validation;
        private String terminationUri;
        private String sipTrunkAuthUsername;
        private String sipTrunkAuthPassword;
        private List<AgentWeight> inboundAgents;
        private List<AgentWeight> outboundAgents;
        private String nickname;
        private String inboundWebhookUrl;
        private List<String> allowedInboundCountryList;
        private List<String> allowedOutboundCountryList;
        private String transport;

        private Builder() {
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder ignoreE164Validation(Boolean ignoreE164Validation) {
            this.ignoreE164Validation = ignoreE164Validation;
            return this;
        }

        public Builder terminationUri(String terminationUri) {
            this.terminationUri = terminationUri;
            return this;
        }

        public Builder sipTrunkAuthUsername(String sipTrunkAuthUsername) {
            this.sipTrunkAuthUsername = sipTrunkAuthUsername;
            return this;
        }

        public Builder sipTrunkAuthPassword(String sipTrunkAuthPassword) {
            this.sipTrunkAuthPassword = sipTrunkAuthPassword;
            return this;
        }

        public Builder inboundAgents(List<AgentWeight> inboundAgents) {
            this.inboundAgents = inboundAgents;
            return this;
        }

        public Builder outboundAgents(List<AgentWeight> outboundAgents) {
            this.outboundAgents = outboundAgents;
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

        public Builder transport(String transport) {
            this.transport = transport;
            return this;
        }

        public ImportPhoneNumberRequest build() {
            return new ImportPhoneNumberRequest(phoneNumber, ignoreE164Validation, terminationUri, sipTrunkAuthUsername, sipTrunkAuthPassword, inboundAgents, outboundAgents, nickname, inboundWebhookUrl, allowedInboundCountryList, allowedOutboundCountryList, transport);
        }
    }
}
