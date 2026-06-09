package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * Request body for creating a Retell LLM response engine.
 *
 * @param model                   underlying text LLM (defaults to gpt-4.1 if not set).
 * @param s2sModel                underlying speech-to-speech model (mutually exclusive with model).
 * @param modelTemperature        randomness of the response, ranging from 0 to 1.
 * @param modelHighPriority       whether to use the high priority pool for lower latency.
 * @param toolCallStrictMode      whether to use strict mode for tool calls.
 * @param knowledgeBaseIds        knowledge base ids to use for this resource.
 * @param kbConfig                knowledge base configuration for RAG retrieval.
 * @param startSpeaker            the speaker who starts the conversation.
 * @param beginAfterUserSilenceMs how long to wait for the user before the AI begins, in milliseconds.
 * @param beginMessage            first utterance said by the agent.
 * @param generalPrompt           general prompt appended to the system prompt regardless of state.
 * @param generalTools            tools the model may call regardless of state.
 * @param states                  states of the LLM.
 * @param startingState           name of the starting state (required if states is non-empty).
 * @param defaultDynamicVariables default dynamic variables injected into prompts and tool descriptions.
 * @param mcps                    MCP servers to use for this LLM.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateRetellLlmRequest(
        NullableLLMModel model,
        S2sModel s2sModel,
        Double modelTemperature,
        Boolean modelHighPriority,
        Boolean toolCallStrictMode,
        List<String> knowledgeBaseIds,
        KBConfig kbConfig,
        StartSpeaker startSpeaker,
        Integer beginAfterUserSilenceMs,
        String beginMessage,
        String generalPrompt,
        List<Tool> generalTools,
        List<State> states,
        String startingState,
        Map<String, String> defaultDynamicVariables,
        List<MCP> mcps
) {
}
