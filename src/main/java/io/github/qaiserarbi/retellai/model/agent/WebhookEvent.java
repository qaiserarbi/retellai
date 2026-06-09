package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Webhook event types an agent can receive. */
public enum WebhookEvent {
    CALL_STARTED("call_started"),
    CALL_ENDED("call_ended"),
    CALL_ANALYZED("call_analyzed"),
    TRANSCRIPT_UPDATED("transcript_updated"),
    TRANSFER_STARTED("transfer_started"),
    TRANSFER_BRIDGED("transfer_bridged"),
    TRANSFER_CANCELLED("transfer_cancelled"),
    TRANSFER_ENDED("transfer_ended");

    private final String value;

    WebhookEvent(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static WebhookEvent from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown WebhookEvent: " + v);
    }
}
