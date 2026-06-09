package io.github.qaiserarbi.retellai.model.llm;

import java.util.List;
import java.util.Map;

/**
 * A Retell LLM response engine.
 *
 * @param llmId                     unique id of the Retell LLM response engine.
 * @param version                   version of the Retell LLM response engine.
 * @param isPublished               whether the Retell LLM response engine is published.
 * @param model                     underlying text LLM.
 * @param s2sModel                  underlying speech-to-speech model.
 * @param modelTemperature          randomness of the response, ranging from 0 to 1.
 * @param modelHighPriority         whether the high priority pool is used.
 * @param toolCallStrictMode        whether strict mode is used for tool calls.
 * @param knowledgeBaseIds          knowledge base ids used for this resource.
 * @param kbConfig                  knowledge base configuration for RAG retrieval.
 * @param startSpeaker              the speaker who starts the conversation.
 * @param beginAfterUserSilenceMs   how long to wait for the user before the AI begins, in milliseconds.
 * @param beginMessage              first utterance said by the agent.
 * @param generalPrompt             general prompt appended to the system prompt regardless of state.
 * @param generalTools              tools the model may call regardless of state.
 * @param states                    states of the LLM.
 * @param startingState             name of the starting state.
 * @param defaultDynamicVariables   default dynamic variables injected into prompts and tool descriptions.
 * @param mcps                      MCP servers used for this LLM.
 * @param lastModificationTimestamp last modification timestamp (milliseconds since epoch).
 */
public record RetellLLMResponse(
        String llmId,
        Integer version,
        Boolean isPublished,
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
        List<MCP> mcps,
        Long lastModificationTimestamp
) {
}
