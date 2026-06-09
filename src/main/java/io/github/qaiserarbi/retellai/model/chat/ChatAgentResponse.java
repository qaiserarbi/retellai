package io.github.qaiserarbi.retellai.model.chat;

import io.github.qaiserarbi.retellai.model.agent.GuardrailConfig;
import io.github.qaiserarbi.retellai.model.agent.PIIConfig;
import io.github.qaiserarbi.retellai.model.common.PostChatAnalysisData;
import io.github.qaiserarbi.retellai.model.common.ResponseEngine;
import io.github.qaiserarbi.retellai.model.llm.NullableLLMModel;
import java.util.List;

/**
 * A chat agent, including identity, version metadata, and the configuration
 * fields shared with {@link ChatAgentRequest}.
 *
 * @param agentId                    unique id of the chat agent.
 * @param version                    the version of the chat agent.
 * @param baseVersion                version that this draft was based on (null for initial versions).
 * @param assignedTags               tags assigned to this chat agent version (preferred tag first).
 * @param isPublished                whether the chat agent is published.
 * @param responseEngine             the Response Engine attached to the agent.
 * @param agentName                  the name of the chat agent.
 * @param autoCloseMessage           message to display when the chat is automatically closed.
 * @param endChatAfterSilenceMs      end the chat after this period of user silence (ms).
 * @param language                   the language(s) the agent operates in.
 * @param webhookUrl                 webhook for the agent to listen to chat events.
 * @param webhookEvents              which webhook events this agent receives.
 * @param webhookTimeoutMs           the timeout for the webhook in milliseconds.
 * @param dataStorageSetting         controls what data is stored for this agent.
 * @param dataStorageRetentionDays   number of days to retain chat data before automatic deletion.
 * @param optInSignedUrl             whether this agent opts in to signed url for public log.
 * @param signedUrlExpirationMs      expiration time for the signed url in milliseconds.
 * @param postChatAnalysisData       post-chat analysis data to extract from the chat.
 * @param postChatAnalysisModel      the model used for post-chat analysis.
 * @param analysisSuccessfulPrompt   prompt to evaluate whether the chat is successful.
 * @param analysisSummaryPrompt      prompt to summarize the chat.
 * @param analysisUserSentimentPrompt prompt guiding user sentiment evaluation.
 * @param piiConfig                  configuration for PII scrubbing.
 * @param guardrailConfig            configuration for guardrail checks.
 * @param handbookConfig             behavior presets influencing agent response style.
 * @param timezone                   IANA timezone for the agent.
 * @param lastModificationTimestamp  last modification timestamp (milliseconds since epoch).
 */
public record ChatAgentResponse(
        String agentId,
        Integer version,
        Integer baseVersion,
        List<String> assignedTags,
        Boolean isPublished,
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
        String timezone,
        Long lastModificationTimestamp) {
}
