package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.chat.ChatAgentResponse;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/** HTTP interface for the Retell AI Chat Agent version endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface ChatAgentVersionApi {

    /**
     * Get all versions of a chat agent.
     *
     * @param agentId unique id of the chat agent.
     * @return all versions of the chat agent.
     */
    @GetExchange("/get-chat-agent-versions/{agent_id}")
    List<ChatAgentResponse> getChatAgentVersions(@PathVariable("agent_id") String agentId);
}
