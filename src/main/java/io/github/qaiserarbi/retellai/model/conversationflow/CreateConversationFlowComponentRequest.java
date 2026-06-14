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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateConversationFlowComponentRequest}. */
    public static final class Builder {
        private String name;
        private Boolean flexMode;
        private List<Map<String, Object>> tools;
        private List<Map<String, Object>> mcps;
        private List<ConversationFlowNode> nodes;
        private String startNodeId;
        private DisplayPosition beginTagDisplayPosition;
        private List<Note> notes;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
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

        public Builder mcps(List<Map<String, Object>> mcps) {
            this.mcps = mcps;
            return this;
        }

        public Builder nodes(List<ConversationFlowNode> nodes) {
            this.nodes = nodes;
            return this;
        }

        public Builder startNodeId(String startNodeId) {
            this.startNodeId = startNodeId;
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

        public CreateConversationFlowComponentRequest build() {
            return new CreateConversationFlowComponentRequest(name, flexMode, tools, mcps, nodes,
                    startNodeId, beginTagDisplayPosition, notes);
        }
    }
}
