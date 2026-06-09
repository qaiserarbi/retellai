package io.github.qaiserarbi.retellai.model.conversationflow;

import java.util.List;
import java.util.Map;

/**
 * A conversation flow component as returned by the API, extending the create request with
 * server-assigned identification and linkage metadata.
 *
 * @param conversationFlowComponentId unique identifier for the component.
 * @param userModifiedTimestamp       timestamp (epoch ms) of the last user modification.
 * @param linkedConversationFlowIds   ids of conversation flows linked to this shared component.
 * @param name                        name of the component.
 * @param flexMode                    if enabled, the component is converted to a single-prompt
 *                                    agent.
 * @param tools                       tools available within the component (free-form objects).
 * @param mcps                        MCP server configurations for this component (free-form).
 * @param nodes                       nodes that make up the component.
 * @param startNodeId                 id of the starting node.
 * @param beginTagDisplayPosition     display position for the begin tag.
 * @param notes                       visual annotations on the canvas.
 */
public record ConversationFlowComponentResponse(
        String conversationFlowComponentId,
        Long userModifiedTimestamp,
        List<String> linkedConversationFlowIds,
        String name,
        Boolean flexMode,
        List<Map<String, Object>> tools,
        List<Map<String, Object>> mcps,
        List<ConversationFlowNode> nodes,
        String startNodeId,
        DisplayPosition beginTagDisplayPosition,
        List<Note> notes
) {
}
