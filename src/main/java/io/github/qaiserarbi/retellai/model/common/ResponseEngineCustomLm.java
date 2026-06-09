package io.github.qaiserarbi.retellai.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Response engine backed by a custom LLM reached over a websocket.
 *
 * @param llmWebsocketUrl LLM websocket url of the custom LLM.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseEngineCustomLm(
        String llmWebsocketUrl
) implements ResponseEngine {
}
