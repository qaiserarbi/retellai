package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Agent version reference. Supports a numeric version (for example {@code 3}) or a
 * tag/environment name (for example {@code "prod"}). The string {@code "latest"} resolves
 * to the most recently created version, and {@code "latest_published"} resolves to the most
 * recently published version.
 */
public record AgentVersionReference(@JsonValue Object value) {

    @JsonCreator
    public AgentVersionReference {
    }

    public static AgentVersionReference of(int version) {
        return new AgentVersionReference(version);
    }

    public static AgentVersionReference of(String tag) {
        return new AgentVersionReference(tag);
    }
}
