package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.agent.GuardrailConfig;
import io.github.qaiserarbi.retellai.model.agent.PIIConfig;
import io.github.qaiserarbi.retellai.model.common.PostChatAnalysisData;
import io.github.qaiserarbi.retellai.model.common.ResponseEngine;
import io.github.qaiserarbi.retellai.model.llm.NullableLLMModel;
import java.util.List;

/**
 * Request body for creating or updating a chat agent.
 *
 * @param responseEngine             the Response Engine to attach to the agent.
 * @param agentName                  the name of the chat agent (for your own reference).
 * @param autoCloseMessage           message to display when the chat is automatically closed.
 * @param endChatAfterSilenceMs      end the chat after this period of user silence (ms).
 * @param language                   the language(s) the agent operates in. Either a single
 *                                   scalar locale / the legacy {@code multi} value, or an array
 *                                   of concrete locale codes.
 * @param webhookUrl                 webhook for the agent to listen to chat events.
 * @param webhookEvents              which webhook events this agent should receive.
 * @param webhookTimeoutMs           the timeout for the webhook in milliseconds.
 * @param dataStorageSetting         controls what data is stored for this agent.
 * @param dataStorageRetentionDays   number of days to retain chat data before automatic deletion.
 * @param optInSignedUrl             whether this agent opts in to signed url for public log.
 * @param signedUrlExpirationMs      expiration time for the signed url in milliseconds.
 * @param postChatAnalysisData       post-chat analysis data to extract from the chat.
 * @param postChatAnalysisModel      the model to use for post-chat analysis.
 * @param analysisSuccessfulPrompt   prompt to evaluate whether the chat is successful.
 * @param analysisSummaryPrompt      prompt to summarize the chat.
 * @param analysisUserSentimentPrompt prompt guiding user sentiment evaluation.
 * @param piiConfig                  configuration for PII scrubbing.
 * @param guardrailConfig            configuration for guardrail checks.
 * @param handbookConfig             behavior presets to influence agent response style.
 * @param timezone                   IANA timezone for the agent.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChatAgentRequest(
        ResponseEngine responseEngine,
        String agentName,
        String autoCloseMessage,
        Integer endChatAfterSilenceMs,
        Object language,
        String webhookUrl,
        List<ChatWebhookEvent> webhookEvents,
        Integer webhookTimeoutMs,
        ChatDataStorageSetting dataStorageSetting,
        Integer dataStorageRetentionDays,
        Boolean optInSignedUrl,
        Integer signedUrlExpirationMs,
        List<PostChatAnalysisData> postChatAnalysisData,
        NullableLLMModel postChatAnalysisModel,
        String analysisSuccessfulPrompt,
        String analysisSummaryPrompt,
        String analysisUserSentimentPrompt,
        PIIConfig piiConfig,
        GuardrailConfig guardrailConfig,
        ChatHandbookConfig handbookConfig,
        String timezone) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link ChatAgentRequest}. */
    public static final class Builder {
        private ResponseEngine responseEngine;
        private String agentName;
        private String autoCloseMessage;
        private Integer endChatAfterSilenceMs;
        private Object language;
        private String webhookUrl;
        private List<ChatWebhookEvent> webhookEvents;
        private Integer webhookTimeoutMs;
        private ChatDataStorageSetting dataStorageSetting;
        private Integer dataStorageRetentionDays;
        private Boolean optInSignedUrl;
        private Integer signedUrlExpirationMs;
        private List<PostChatAnalysisData> postChatAnalysisData;
        private NullableLLMModel postChatAnalysisModel;
        private String analysisSuccessfulPrompt;
        private String analysisSummaryPrompt;
        private String analysisUserSentimentPrompt;
        private PIIConfig piiConfig;
        private GuardrailConfig guardrailConfig;
        private ChatHandbookConfig handbookConfig;
        private String timezone;

        private Builder() {
        }

        public Builder responseEngine(ResponseEngine responseEngine) {
            this.responseEngine = responseEngine;
            return this;
        }

        public Builder agentName(String agentName) {
            this.agentName = agentName;
            return this;
        }

        public Builder autoCloseMessage(String autoCloseMessage) {
            this.autoCloseMessage = autoCloseMessage;
            return this;
        }

        public Builder endChatAfterSilenceMs(Integer endChatAfterSilenceMs) {
            this.endChatAfterSilenceMs = endChatAfterSilenceMs;
            return this;
        }

        public Builder language(Object language) {
            this.language = language;
            return this;
        }

        public Builder webhookUrl(String webhookUrl) {
            this.webhookUrl = webhookUrl;
            return this;
        }

        public Builder webhookEvents(List<ChatWebhookEvent> webhookEvents) {
            this.webhookEvents = webhookEvents;
            return this;
        }

        public Builder webhookTimeoutMs(Integer webhookTimeoutMs) {
            this.webhookTimeoutMs = webhookTimeoutMs;
            return this;
        }

        public Builder dataStorageSetting(ChatDataStorageSetting dataStorageSetting) {
            this.dataStorageSetting = dataStorageSetting;
            return this;
        }

        public Builder dataStorageRetentionDays(Integer dataStorageRetentionDays) {
            this.dataStorageRetentionDays = dataStorageRetentionDays;
            return this;
        }

        public Builder optInSignedUrl(Boolean optInSignedUrl) {
            this.optInSignedUrl = optInSignedUrl;
            return this;
        }

        public Builder signedUrlExpirationMs(Integer signedUrlExpirationMs) {
            this.signedUrlExpirationMs = signedUrlExpirationMs;
            return this;
        }

        public Builder postChatAnalysisData(List<PostChatAnalysisData> postChatAnalysisData) {
            this.postChatAnalysisData = postChatAnalysisData;
            return this;
        }

        public Builder postChatAnalysisModel(NullableLLMModel postChatAnalysisModel) {
            this.postChatAnalysisModel = postChatAnalysisModel;
            return this;
        }

        public Builder analysisSuccessfulPrompt(String analysisSuccessfulPrompt) {
            this.analysisSuccessfulPrompt = analysisSuccessfulPrompt;
            return this;
        }

        public Builder analysisSummaryPrompt(String analysisSummaryPrompt) {
            this.analysisSummaryPrompt = analysisSummaryPrompt;
            return this;
        }

        public Builder analysisUserSentimentPrompt(String analysisUserSentimentPrompt) {
            this.analysisUserSentimentPrompt = analysisUserSentimentPrompt;
            return this;
        }

        public Builder piiConfig(PIIConfig piiConfig) {
            this.piiConfig = piiConfig;
            return this;
        }

        public Builder guardrailConfig(GuardrailConfig guardrailConfig) {
            this.guardrailConfig = guardrailConfig;
            return this;
        }

        public Builder handbookConfig(ChatHandbookConfig handbookConfig) {
            this.handbookConfig = handbookConfig;
            return this;
        }

        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public ChatAgentRequest build() {
            return new ChatAgentRequest(responseEngine, agentName, autoCloseMessage,
                    endChatAfterSilenceMs, language, webhookUrl, webhookEvents, webhookTimeoutMs,
                    dataStorageSetting, dataStorageRetentionDays, optInSignedUrl,
                    signedUrlExpirationMs, postChatAnalysisData, postChatAnalysisModel,
                    analysisSuccessfulPrompt, analysisSummaryPrompt, analysisUserSentimentPrompt,
                    piiConfig, guardrailConfig, handbookConfig, timezone);
        }
    }
}
