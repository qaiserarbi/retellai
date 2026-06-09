package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Filter criteria for calls. All conditions are implicitly connected with AND.
 * The individual filter fields accept the loosely-typed filter shapes documented
 * in the Retell API (string/enum/number/range/boolean filters); they are modeled
 * as free-form values so any supported filter shape round-trips.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CallFilter(
        List<Object> agent,
        Object callId,
        Object batchCallId,
        Object callStatus,
        Object inVoicemail,
        Object disconnectionReason,
        Object fromNumber,
        Object toNumber,
        Object callType,
        Object direction,
        Object userSentiment,
        Object dataStorageSetting,
        Object callSuccessful,
        Object startTimestamp,
        Object endTimestamp,
        Object durationMs,
        Object combinedCost,
        Object e2eLatencyP50,
        List<Object> toolCalls,
        List<Object> customAnalysisData,
        List<Object> customAttributes,
        List<Object> metadata,
        List<Object> dynamicVariables) {
}
