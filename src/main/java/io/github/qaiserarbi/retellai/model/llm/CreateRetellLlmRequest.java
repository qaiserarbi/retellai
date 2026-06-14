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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateRetellLlmRequest}. */
    public static final class Builder {
        private NullableLLMModel model;
        private S2sModel s2sModel;
        private Double modelTemperature;
        private Boolean modelHighPriority;
        private Boolean toolCallStrictMode;
        private List<String> knowledgeBaseIds;
        private KBConfig kbConfig;
        private StartSpeaker startSpeaker;
        private Integer beginAfterUserSilenceMs;
        private String beginMessage;
        private String generalPrompt;
        private List<Tool> generalTools;
        private List<State> states;
        private String startingState;
        private Map<String, String> defaultDynamicVariables;
        private List<MCP> mcps;

        private Builder() {
        }

        public Builder model(NullableLLMModel model) {
            this.model = model;
            return this;
        }

        public Builder s2sModel(S2sModel s2sModel) {
            this.s2sModel = s2sModel;
            return this;
        }

        public Builder modelTemperature(Double modelTemperature) {
            this.modelTemperature = modelTemperature;
            return this;
        }

        public Builder modelHighPriority(Boolean modelHighPriority) {
            this.modelHighPriority = modelHighPriority;
            return this;
        }

        public Builder toolCallStrictMode(Boolean toolCallStrictMode) {
            this.toolCallStrictMode = toolCallStrictMode;
            return this;
        }

        public Builder knowledgeBaseIds(List<String> knowledgeBaseIds) {
            this.knowledgeBaseIds = knowledgeBaseIds;
            return this;
        }

        public Builder kbConfig(KBConfig kbConfig) {
            this.kbConfig = kbConfig;
            return this;
        }

        public Builder startSpeaker(StartSpeaker startSpeaker) {
            this.startSpeaker = startSpeaker;
            return this;
        }

        public Builder beginAfterUserSilenceMs(Integer beginAfterUserSilenceMs) {
            this.beginAfterUserSilenceMs = beginAfterUserSilenceMs;
            return this;
        }

        public Builder beginMessage(String beginMessage) {
            this.beginMessage = beginMessage;
            return this;
        }

        public Builder generalPrompt(String generalPrompt) {
            this.generalPrompt = generalPrompt;
            return this;
        }

        public Builder generalTools(List<Tool> generalTools) {
            this.generalTools = generalTools;
            return this;
        }

        public Builder states(List<State> states) {
            this.states = states;
            return this;
        }

        public Builder startingState(String startingState) {
            this.startingState = startingState;
            return this;
        }

        public Builder defaultDynamicVariables(Map<String, String> defaultDynamicVariables) {
            this.defaultDynamicVariables = defaultDynamicVariables;
            return this;
        }

        public Builder mcps(List<MCP> mcps) {
            this.mcps = mcps;
            return this;
        }

        public CreateRetellLlmRequest build() {
            return new CreateRetellLlmRequest(model, s2sModel, modelTemperature, modelHighPriority,
                    toolCallStrictMode, knowledgeBaseIds, kbConfig, startSpeaker, beginAfterUserSilenceMs,
                    beginMessage, generalPrompt, generalTools, states, startingState,
                    defaultDynamicVariables, mcps);
        }
    }
}
