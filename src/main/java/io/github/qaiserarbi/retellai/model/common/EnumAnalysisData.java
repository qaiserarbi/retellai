package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Enum custom analysis data field.
 *
 * @param name              name of the variable.
 * @param description       description of the variable.
 * @param choices           the possible values of the variable, must be a non-empty array.
 * @param required          whether this data is required.
 * @param conditionalPrompt optional instruction deciding whether this field needs to be populated.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnumAnalysisData(
        String name,
        String description,
        List<String> choices,
        Boolean required,
        String conditionalPrompt
) implements AnalysisData, PostCallAnalysisData, PostChatAnalysisData {
}
