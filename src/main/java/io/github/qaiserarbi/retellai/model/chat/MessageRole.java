package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Role discriminator for messages woven into a chat transcript. Doubles as the
 * {@code role} discriminator value for the {@link MessageOrToolCall} union.
 */
public enum MessageRole {
    AGENT("agent"),
    USER("user"),
    TOOL_CALL_INVOCATION("tool_call_invocation"),
    TOOL_CALL_RESULT("tool_call_result"),
    NODE_TRANSITION("node_transition"),
    STATE_TRANSITION("state_transition"),
    INJECTED("injected"),
    SMS("sms");

    private final String value;

    MessageRole(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static MessageRole from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown MessageRole: " + v);
    }
}
