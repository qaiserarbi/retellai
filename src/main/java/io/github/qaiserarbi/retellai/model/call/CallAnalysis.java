package io.github.qaiserarbi.retellai.model.call;

import java.util.Map;

/**
 * Post-call analysis that includes information such as sentiment, status,
 * summary, and custom defined data to extract.
 */
public record CallAnalysis(
        String callSummary,
        Boolean inVoicemail,
        UserSentiment userSentiment,
        Boolean callSuccessful,
        Map<String, Object> customAnalysisData) {
}
