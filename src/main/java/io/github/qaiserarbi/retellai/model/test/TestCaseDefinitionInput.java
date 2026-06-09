package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.llm.LLMModel;
import java.util.List;
import java.util.Map;

/**
 * Input payload to create or update a test case definition.
 *
 * @param name             name of the test case definition
 * @param responseEngine   response engine to use for the test case (Custom LLM not supported)
 * @param userPrompt       user prompt to simulate in the test case
 * @param metrics          metric names to evaluate
 * @param dynamicVariables dynamic variables to inject into the response engine
 * @param toolMocks        mock tool calls for testing
 * @param llmModel         LLM model to use for simulation
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TestCaseDefinitionInput(
        String name,
        RetellResponseEngine responseEngine,
        String userPrompt,
        List<String> metrics,
        Map<String, String> dynamicVariables,
        List<ToolMock> toolMocks,
        LLMModel llmModel
) {
}
