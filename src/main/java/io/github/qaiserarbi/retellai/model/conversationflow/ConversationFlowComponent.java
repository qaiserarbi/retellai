package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * A conversation flow component: a reusable cluster of nodes. Used as the update request body for
 * a shared component and as the base for {@link CreateConversationFlowComponentRequest}.
 *
 * @param name                    name of the component.
 * @param flexMode                if enabled, the component is converted to a single-prompt agent.
 * @param tools                   tools available within the component (free-form NodeTool objects).
 * @param mcps                    MCP server configurations for this component (free-form objects).
 * @param nodes                   nodes that make up the component.
 * @param startNodeId             id of the starting node.
 * @param beginTagDisplayPosition display position for the begin tag.
 * @param notes                   visual annotations on the canvas.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConversationFlowComponent(
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
