package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Latency tracking of the call, available after call ends. Not all fields will
 * be available, as it depends on the type of call and feature used.
 */
public record CallLatencyBreakdown(
        CallLatency e2e,
        CallLatency asr,
        CallLatency llm,
        @JsonProperty("llm_websocket_network_rtt") CallLatency llmWebsocketNetworkRtt,
        CallLatency tts,
        CallLatency knowledgeBase,
        CallLatency s2s) {
}
