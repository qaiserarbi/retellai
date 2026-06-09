package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * IVR action that hangs up the call when an IVR is detected.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record IvrActionHangup() implements IvrAction {
}
