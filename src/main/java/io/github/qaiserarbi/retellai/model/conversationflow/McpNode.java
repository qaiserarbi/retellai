package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 * A node that calls a tool exposed by an MCP server.
 *
 * @param id                         unique identifier for the node.
 * @param name                       optional display name.
 * @param globalNodeSetting          optional global node configuration.
 * @param displayPosition            frontend display position.
 * @param modelChoice                model choice override for this node (free-form).
 * @param mcpId                      unique id of the MCP server.
 * @param mcpToolName                name of the MCP tool to call.
 * @param edges                      conditional transition edges.
 * @param elseEdge                   default edge when no condition matches.
 * @param responseVariables          response variables to add to dynamic variables.
 * @param speakDuringExecution       if true, speaks during execution.
 * @param instruction                what to say during execution.
 * @param waitForResult              if true, wait for the result before transitioning.
 * @param enableTypingSound          if true, play a typing sound while executing.
 * @param finetuneTransitionExamples transition finetune examples.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpNode(
        String id,
        String name,
        GlobalNodeSetting globalNodeSetting,
        DisplayPosition displayPosition,
        Map<String, Object> modelChoice,
        String mcpId,
        String mcpToolName,
        List<NodeEdge> edges,
        NodeEdge elseEdge,
        Map<String, String> responseVariables,
        Boolean speakDuringExecution,
        NodeInstruction instruction,
        Boolean waitForResult,
        Boolean enableTypingSound,
        List<NodeFinetuneTransitionExample> finetuneTransitionExamples
) implements ConversationFlowNode {
}
