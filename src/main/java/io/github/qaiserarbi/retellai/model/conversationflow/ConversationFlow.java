package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * A conversation flow definition. Used as the request body for updating a conversation flow and
 * as the base for {@link CreateConversationFlowRequest}.
 *
 * <p>Inlines the {@code ConversationFlowOverride} base fields (model choice, temperature, etc.)
 * together with the flow-specific fields.</p>
 *
 * @param modelChoice               the model choice for the conversation flow (free-form).
 * @param modelTemperature          controls randomness of responses (0-1).
 * @param toolCallStrictMode        whether to use strict mode for tool calls.
 * @param knowledgeBaseIds          knowledge base ids for RAG.
 * @param kbConfig                  knowledge base configuration for RAG retrieval.
 * @param startSpeaker              who starts the conversation.
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
 * @param nodes                     the nodes that make up the flow.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConversationFlow(
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
}
