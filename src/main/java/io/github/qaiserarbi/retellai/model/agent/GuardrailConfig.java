package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Configuration for guardrail checks to detect and prevent prohibited topics.
 *
 * @param outputTopics prohibited agent output topic categories to check
 * @param inputTopics  prohibited user input topic categories to check
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record GuardrailConfig(
        List<GuardrailOutputTopic> outputTopics,
        List<GuardrailInputTopic> inputTopics
) {
}
