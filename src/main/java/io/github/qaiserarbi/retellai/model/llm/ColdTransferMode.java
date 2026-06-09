package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** The mode of a cold transfer. */
public enum ColdTransferMode {
    SIP_REFER("sip_refer"),
    SIP_INVITE("sip_invite");

    private final String value;

    ColdTransferMode(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ColdTransferMode from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ColdTransferMode: " + v);
    }
}
