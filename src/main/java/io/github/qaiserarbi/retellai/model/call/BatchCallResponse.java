package io.github.qaiserarbi.retellai.model.call;

/** Response returned after creating a batch call. */
public record BatchCallResponse(
        String batchCallId,
        String name,
        String fromNumber,
        Long scheduledTimestamp,
        Double totalTaskCount,
        CallTimeWindow callTimeWindow) {
}
