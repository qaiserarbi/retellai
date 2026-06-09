package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * A state of the LLM, used to break a call into distinct stages with focused prompts and tools.
 *
 * @param name        unique name of the state.
 * @param statePrompt prompt of the state, appended to the system prompt.
 * @param edges       edges defining which states are reachable from this state.
 * @param tools       tools specific to this state the model may call.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record State(
        String name,
        String statePrompt,
        List<StateEdge> edges,
        List<Tool> tools
) {
}
