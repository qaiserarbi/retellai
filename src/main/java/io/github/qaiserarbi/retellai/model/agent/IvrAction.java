package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Action to take when an IVR is detected on the call.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IvrActionHangup.class, name = "hangup")
})
public sealed interface IvrAction permits IvrActionHangup {
}
