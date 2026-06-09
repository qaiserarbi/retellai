package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AnalysisData;

import java.util.List;

/**
 * A tool that extracts dynamic variables from the conversation.
 *
 * @param name              unique name of the tool.
 * @param description       describes what the tool does and when to call it.
 * @param variables         the variables to be extracted.
 * @param enableTypingSound if true, play a typing sound while the tool executes.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExtractDynamicVariableTool(
        String name,
        String description,
        List<AnalysisData> variables,
        Boolean enableTypingSound
) implements Tool {
}
