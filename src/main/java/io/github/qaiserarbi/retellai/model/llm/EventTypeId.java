package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Cal.com event type id. Can be a number or a dynamic-variable string like
 * {@code {{variable_name}}} resolved at runtime.
 */
public record EventTypeId(@JsonValue Object value) {

    @JsonCreator
    public EventTypeId {
    }

    public static EventTypeId of(int id) {
        return new EventTypeId(id);
    }

    public static EventTypeId of(String variable) {
        return new EventTypeId(variable);
    }
}
