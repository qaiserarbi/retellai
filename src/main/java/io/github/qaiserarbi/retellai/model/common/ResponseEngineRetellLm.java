package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Response engine backed by a Retell LLM.
 *
 * @param llmId   id of the Retell LLM Response Engine.
 * @param version version of the Retell LLM Response Engine.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseEngineRetellLm(
        String llmId,
        Double version
) implements ResponseEngine {
}
