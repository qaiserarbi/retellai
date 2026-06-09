package io.github.qaiserarbi.retellai.model.misc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of an export request.
 */
public enum ExportStatus {
    CREATED("created"),
    PROCESSING("processing"),
    COMPLETED("completed"),
    ERROR("error");

    private final String value;

    ExportStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ExportStatus from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ExportStatus: " + v);
    }
}
