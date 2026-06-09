package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Filter criteria for chats. All conditions are implicitly connected with AND.
 * The individual filter fields accept the loosely-typed filter shapes documented
 * in the Retell API (string/enum/number/range/boolean filters); they are modeled
 * as free-form values so any supported filter shape round-trips.
 *
 * @param agent              filter by agent(s); agent filters are connected by OR.
 * @param chatId             filter by chat ID.
 * @param chatStatus         filter by chat status.
 * @param disconnectionReason filter by disconnection reason.
 * @param userSentiment      filter by user sentiment.
 * @param chatSuccessful     filter by whether the chat was successful.
 * @param startTimestamp     filter by chat start timestamp (epoch ms).
 * @param endTimestamp       filter by chat end timestamp (epoch ms).
 * @param durationMs         filter by chat duration in milliseconds.
 * @param combinedCost       filter by combined cost of the chat.
 * @param customAnalysisData filter by custom analysis data fields.
 * @param customAttributes   filter by custom attributes fields.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChatFilter(
        List<Object> agent,
        Object chatId,
        Object chatStatus,
        Object disconnectionReason,
        Object userSentiment,
        Object chatSuccessful,
        Object startTimestamp,
        Object endTimestamp,
        Object durationMs,
        Object combinedCost,
        List<Object> customAnalysisData,
        List<Object> customAttributes) {
}
