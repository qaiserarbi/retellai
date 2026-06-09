package io.github.qaiserarbi.retellai.model.test;

import io.github.qaiserarbi.retellai.model.llm.LLMModel;
import java.util.List;
import java.util.Map;

/**
 * A test case definition.
 *
 * @param name                   name of the test case definition
 * @param responseEngine         response engine used for the test case
 * @param userPrompt             user prompt to simulate in the test case
 * @param metrics                metric names to evaluate
 * @param dynamicVariables       dynamic variables to inject into the response engine
 * @param toolMocks              mock tool calls for testing
 * @param llmModel               LLM model used for simulation
 * @param testCaseDefinitionId   unique identifier for the test case definition
 * @param type                   type of test case definition
 * @param creationTimestamp      creation timestamp (milliseconds since epoch)
 * @param userModifiedTimestamp  last modification timestamp (milliseconds since epoch)
 */
public record TestCaseDefinition(
        String name,
        RetellResponseEngine responseEngine,
        String userPrompt,
        List<String> metrics,
        Map<String, String> dynamicVariables,
        List<ToolMock> toolMocks,
        LLMModel llmModel,
        String testCaseDefinitionId,
        Type type,
        Long creationTimestamp,
        Long userModifiedTimestamp
) {

    /** Type of a test case definition. */
    public enum Type {
        SIMULATION("simulation");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @com.fasterxml.jackson.annotation.JsonValue
        public String value() {
            return value;
        }

        @com.fasterxml.jackson.annotation.JsonCreator
        public static Type from(String v) {
            for (var e : values()) {
                if (e.value.equals(v)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("Unknown Type: " + v);
        }
    }
}
