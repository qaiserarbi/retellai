package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Action to take when the transfer agent times out without making a decision. */
public enum TransferActionOnTimeout {
    BRIDGE_TRANSFER("bridge_transfer"),
    CANCEL_TRANSFER("cancel_transfer");

    private final String value;

    TransferActionOnTimeout(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static TransferActionOnTimeout from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown TransferActionOnTimeout: " + v);
    }
}
