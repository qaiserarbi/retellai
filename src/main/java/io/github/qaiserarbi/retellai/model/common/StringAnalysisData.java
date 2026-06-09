package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * String custom analysis data field.
 *
 * @param name              name of the variable.
 * @param description       description of the variable.
 * @param examples          examples of the variable value to teach the model style and syntax.
 * @param required          whether this data is required.
 * @param conditionalPrompt optional instruction deciding whether this field needs to be populated.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StringAnalysisData(
        String name,
        String description,
        List<String> examples,
        Boolean required,
        String conditionalPrompt
) implements AnalysisData, PostCallAnalysisData, PostChatAnalysisData {
}
