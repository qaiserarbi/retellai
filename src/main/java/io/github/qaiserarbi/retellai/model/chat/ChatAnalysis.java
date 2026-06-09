package io.github.qaiserarbi.retellai.model.chat;

import java.util.Map;

/**
 * Post-chat analysis including sentiment, status, summary, and custom extracted data.
 *
 * @param chatSummary        a high level summary of the chat.
 * @param userSentiment      sentiment of the user in the chat.
 * @param chatSuccessful     whether the agent had a successful chat with the user.
 * @param customAnalysisData custom analysis data extracted based on the configured schema.
 */
public record ChatAnalysis(
        String chatSummary,
        ChatUserSentiment userSentiment,
        Boolean chatSuccessful,
        Map<String, Object> customAnalysisData) {
}
