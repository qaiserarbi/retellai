package io.github.qaiserarbi.retellai.model.call;

import java.util.List;
import java.util.Map;

/**
 * A phone call returned by the v2 call APIs. Carries the shared call base fields
 * plus phone-specific fields.
 */
public record V2PhoneCallResponse(
        // phone-specific fields
        String fromNumber,
        String toNumber,
        CallDirection direction,
        TelephonyIdentifier telephonyIdentifier,
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
        String transcript,
        List<Map<String, Object>> transcriptObject,
        List<Map<String, Object>> transcriptWithToolCalls,
        List<Map<String, Object>> scrubbedTranscriptWithToolCalls,
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
        LlmTokenUsage llmTokenUsage) implements V2CallResponse {
}
