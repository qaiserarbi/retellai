package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Webhook events a chat agent can subscribe to. */
public enum ChatWebhookEvent {
    CHAT_STARTED("chat_started"),
    CHAT_ENDED("chat_ended"),
    CHAT_ANALYZED("chat_analyzed"),
    TRANSCRIPT_UPDATED("transcript_updated");

    private final String value;

    ChatWebhookEvent(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatWebhookEvent from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatWebhookEvent: " + v);
    }
}
