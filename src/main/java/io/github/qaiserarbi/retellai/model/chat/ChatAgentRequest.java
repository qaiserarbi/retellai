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
}
