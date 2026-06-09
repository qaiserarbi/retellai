package io.github.qaiserarbi.retellai.model.call;

import java.util.Map;

/**
 * A web call returned by the v3 call APIs. Carries the shared call base fields
 * plus web-specific fields.
 */
public record V3WebCallResponse(
        // web-specific fields
        String accessToken,
        // shared base fields
        String callId,
        String agentId,
        String agentName,
        Integer agentVersion,
        CallStatus callStatus,
        Map<String, Object> metadata,
        Map<String, String> retellLlmDynamicVariables,
        Map<String, String> collectedDynamicVariables,
        Map<String, String> customSipHeaders,
        DataStorageSetting dataStorageSetting,
        Boolean optInSignedUrl,
        Long startTimestamp,
        Long endTimestamp,
        Long transferEndTimestamp,
        Long durationMs,
        String recordingUrl,
        String recordingMultiChannelUrl,
        String scrubbedRecordingUrl,
        String scrubbedRecordingMultiChannelUrl,
        String publicLogUrl,
        String knowledgeBaseRetrievedContentsUrl,
        CallLatencyBreakdown latency,
        DisconnectionReason disconnectionReason,
        String transferDestination,
        CallAnalysis callAnalysis,
        CallCost callCost,
        LlmTokenUsage llmTokenUsage) implements V3CallResponse {
}
