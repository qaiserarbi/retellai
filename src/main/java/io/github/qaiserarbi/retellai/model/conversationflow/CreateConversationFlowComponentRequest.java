package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * Request body for creating a conversation flow component. Structurally identical to
 * {@link ConversationFlowComponent} but with {@code name} and {@code nodes} being required.
 *
 * @param name                    name of the component (required).
 * @param flexMode                if enabled, the component is converted to a single-prompt agent.
 * @param tools                   tools available within the component (free-form NodeTool objects).
 * @param mcps                    MCP server configurations for this component (free-form objects).
 * @param nodes                   nodes that make up the component (required).
 * @param startNodeId             id of the starting node.
 * @param beginTagDisplayPosition display position for the begin tag.
 * @param notes                   visual annotations on the canvas.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateConversationFlowComponentRequest(
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
