package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A static-message warm transfer handoff option.
 *
 * @param message the static message to be used for warm handoff. Can contain dynamic variables.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record WarmTransferStaticMessage(
        String message
) implements WarmTransferHandoffOption {
}
