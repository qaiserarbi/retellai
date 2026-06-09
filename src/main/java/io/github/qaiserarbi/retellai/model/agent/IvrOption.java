package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * IVR detection option. When set, the call attempts to detect IVR and applies the
 * configured action.
 *
 * @param action          action to apply when an IVR is detected
 * @param detectionPrompt optional description of what should be treated as an IVR
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record IvrOption(
        IvrAction action,
        String detectionPrompt
) {
}
