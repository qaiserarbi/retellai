package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A transfer destination inferred at runtime from a prompt.
 *
 * @param prompt the prompt used to help infer the transfer destination. Can contain dynamic variables.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransferDestinationInferred(
        String prompt
) implements TransferDestination {
}
