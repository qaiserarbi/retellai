package io.github.qaiserarbi.retellai.model.knowledgebase;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Status of a knowledge base.
 */
public enum KnowledgeBaseStatus {
    IN_PROGRESS("in_progress"),
    COMPLETE("complete"),
    ERROR("error"),
    REFRESHING_IN_PROGRESS("refreshing_in_progress");

    private final String value;

    KnowledgeBaseStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static KnowledgeBaseStatus from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown KnowledgeBaseStatus: " + v);
    }
}
