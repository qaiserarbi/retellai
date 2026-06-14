package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * Request body for creating a conversation flow. Structurally identical to {@link ConversationFlow}
 * but with {@code startSpeaker}, {@code modelChoice} and {@code nodes} being required.
 *
 * @param modelChoice               the model choice for the conversation flow (required, free-form).
 * @param modelTemperature          controls randomness of responses (0-1).
 * @param toolCallStrictMode        whether to use strict mode for tool calls.
 * @param knowledgeBaseIds          knowledge base ids for RAG.
 * @param kbConfig                  knowledge base configuration for RAG retrieval.
 * @param startSpeaker              who starts the conversation (required).
 * @param beginAfterUserSilenceMs   if set, the AI begins after waiting this long for the user.
 * @param globalPrompt              global prompt used in every node.
 * @param flexMode                  if enabled, the flow is converted to a single-prompt agent.
 * @param tools                     tools available in the flow (free-form NodeTool objects).
 * @param components                local components embedded within the flow.
 * @param startNodeId               id of the start node.
 * @param defaultDynamicVariables   default dynamic variables referenced throughout the flow.
 * @param beginTagDisplayPosition   display position for the begin tag.
 * @param notes                     visual annotations on the canvas.
 * @param mcps                      MCP server configurations for this flow (free-form objects).
 * @param isTransferLlm             whether this flow is used for transfer LLM.
 * @param nodes                     the nodes that make up the flow (required).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateConversationFlowRequest(
        Map<String, Object> modelChoice,
        Double modelTemperature,
        Boolean toolCallStrictMode,
        List<String> knowledgeBaseIds,
        KbConfig kbConfig,
        StartSpeaker startSpeaker,
        Integer beginAfterUserSilenceMs,
        String globalPrompt,
        Boolean flexMode,
        List<Map<String, Object>> tools,
        List<CreateConversationFlowComponentRequest> components,
        String startNodeId,
        Map<String, String> defaultDynamicVariables,
        DisplayPosition beginTagDisplayPosition,
        List<Note> notes,
        List<Map<String, Object>> mcps,
        Boolean isTransferLlm,
        List<ConversationFlowNode> nodes
) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateConversationFlowRequest}. */
    public static final class Builder {
        private Map<String, Object> modelChoice;
        private Double modelTemperature;
        private Boolean toolCallStrictMode;
        private List<String> knowledgeBaseIds;
        private KbConfig kbConfig;
        private StartSpeaker startSpeaker;
        private Integer beginAfterUserSilenceMs;
        private String globalPrompt;
        private Boolean flexMode;
        private List<Map<String, Object>> tools;
        private List<CreateConversationFlowComponentRequest> components;
        private String startNodeId;
        private Map<String, String> defaultDynamicVariables;
        private DisplayPosition beginTagDisplayPosition;
        private List<Note> notes;
        private List<Map<String, Object>> mcps;
        private Boolean isTransferLlm;
        private List<ConversationFlowNode> nodes;

        private Builder() {
        }

        public Builder modelChoice(Map<String, Object> modelChoice) {
            this.modelChoice = modelChoice;
            return this;
        }

        public Builder modelTemperature(Double modelTemperature) {
            this.modelTemperature = modelTemperature;
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

        public Builder kbConfig(KbConfig kbConfig) {
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

        public Builder globalPrompt(String globalPrompt) {
            this.globalPrompt = globalPrompt;
            return this;
        }

        public Builder flexMode(Boolean flexMode) {
            this.flexMode = flexMode;
            return this;
        }

        public Builder tools(List<Map<String, Object>> tools) {
            this.tools = tools;
            return this;
        }

        public Builder components(List<CreateConversationFlowComponentRequest> components) {
            this.components = components;
            return this;
        }

        public Builder startNodeId(String startNodeId) {
            this.startNodeId = startNodeId;
            return this;
        }

        public Builder defaultDynamicVariables(Map<String, String> defaultDynamicVariables) {
            this.defaultDynamicVariables = defaultDynamicVariables;
            return this;
        }

        public Builder beginTagDisplayPosition(DisplayPosition beginTagDisplayPosition) {
            this.beginTagDisplayPosition = beginTagDisplayPosition;
            return this;
        }

        public Builder notes(List<Note> notes) {
            this.notes = notes;
            return this;
        }

        public Builder mcps(List<Map<String, Object>> mcps) {
            this.mcps = mcps;
            return this;
        }

        public Builder isTransferLlm(Boolean isTransferLlm) {
            this.isTransferLlm = isTransferLlm;
            return this;
        }

        public Builder nodes(List<ConversationFlowNode> nodes) {
            this.nodes = nodes;
            return this;
        }

        public CreateConversationFlowRequest build() {
            return new CreateConversationFlowRequest(modelChoice, modelTemperature, toolCallStrictMode,
                    knowledgeBaseIds, kbConfig, startSpeaker, beginAfterUserSilenceMs, globalPrompt,
                    flexMode, tools, components, startNodeId, defaultDynamicVariables,
                    beginTagDisplayPosition, notes, mcps, isTransferLlm, nodes);
        }
    }
}
