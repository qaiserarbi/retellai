package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.chat.ChatAgentRequest;
import io.github.qaiserarbi.retellai.model.chat.ChatAgentResponse;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;

/** HTTP interface for the Retell AI Chat Agent endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface ChatAgentApi {

    /**
     * Create a new chat agent.
     *
     * @param request the chat agent request (response engine required).
     * @return the created chat agent.
     */
    @PostExchange("/create-chat-agent")
    ChatAgentResponse createChatAgent(@RequestBody ChatAgentRequest request);

    /**
     * Retrieve details of a specific chat agent.
     *
     * @param agentId unique id of the chat agent.
     * @param version optional version to retrieve (defaults to latest).
     * @return the chat agent.
     */
    @GetExchange("/get-chat-agent/{agent_id}")
    ChatAgentResponse getChatAgent(
            @PathVariable("agent_id") String agentId,
            @RequestParam(name = "version", required = false) AgentVersionReference version);

    /**
     * List all chat agents.
     *
     * @param limit                 a limit on the number of objects returned (1-1000).
     * @param paginationKey         pagination key to continue fetching the next page.
     * @param paginationKeyVersion  version of the agent associated with the pagination key.
     * @param isLatest              if true, only return the latest version of each chat agent.
     * @return all chat agents.
     */
    @GetExchange("/list-chat-agents")
    List<ChatAgentResponse> listChatAgents(
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "pagination_key", required = false) String paginationKey,
            @RequestParam(name = "pagination_key_version", required = false) Integer paginationKeyVersion,
            @RequestParam(name = "is_latest", required = false) Boolean isLatest);

    /**
     * Update an existing chat agent.
     *
     * @param agentId unique id of the chat agent to update.
     * @param version optional version to update (defaults to latest).
     * @param request the chat agent request.
     * @return the updated chat agent.
     */
    @PatchExchange("/update-chat-agent/{agent_id}")
    ChatAgentResponse updateChatAgent(
            @PathVariable("agent_id") String agentId,
            @RequestParam(name = "version", required = false) AgentVersionReference version,
            @RequestBody ChatAgentRequest request);

    /**
     * Delete an existing chat agent. Deletes all versions of the chat agent.
     *
     * @param agentId unique id of the chat agent to delete.
     */
    @DeleteExchange("/delete-chat-agent/{agent_id}")
    void deleteChatAgent(@PathVariable("agent_id") String agentId);
}
