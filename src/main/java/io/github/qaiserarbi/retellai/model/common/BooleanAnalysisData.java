package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Boolean custom analysis data field.
 *
 * @param name              name of the variable.
 * @param description       description of the variable.
 * @param required          whether this data is required.
 * @param conditionalPrompt optional instruction deciding whether this field needs to be populated.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BooleanAnalysisData(
        String name,
        String description,
        Boolean required,
        String conditionalPrompt
) implements AnalysisData, PostCallAnalysisData, PostChatAnalysisData {
}
