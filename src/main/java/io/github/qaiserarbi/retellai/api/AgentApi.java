package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.agent.AgentRequest;
import io.github.qaiserarbi.retellai.model.agent.AgentResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/** HTTP interface for the Retell AI Agent endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface AgentApi {

    /**
     * Create a new agent. Requires {@code responseEngine} and {@code voiceId} to be set.
     *
     * @param request the agent configuration.
     * @return the created agent.
     */
    @PostExchange("/create-agent")
    AgentResponse createAgent(@RequestBody AgentRequest request);

    /**
     * Retrieve details of a specific agent.
     *
     * @param agentId Unique id of the agent to be retrieved.
     * @param version Optional version reference (numeric version, tag, {@code latest},
     *                or {@code latest_published}). Defaults to the latest version.
     * @return the agent details.
     */
    @GetExchange("/get-agent/{agent_id}")
    AgentResponse getAgent(
            @PathVariable("agent_id") String agentId,
            @RequestParam(name = "version", required = false) String version);

    /**
     * List all agents.
     *
     * @param limit                A limit on the number of objects returned (1-1000).
     * @param paginationKey        Pagination key (an agent id) to continue fetching.
     * @param paginationKeyVersion Version of the agent associated with the pagination key.
     * @param isLatest             If true, only return the latest version of each agent.
     * @return all agents.
     */
    @GetExchange("/list-agents")
    List<AgentResponse> listAgents(
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "pagination_key", required = false) String paginationKey,
            @RequestParam(name = "pagination_key_version", required = false) Integer paginationKeyVersion,
            @RequestParam(name = "is_latest", required = false) Boolean isLatest);

    /**
     * Update an existing agent's latest draft version.
     *
     * @param agentId Unique id of the agent to be updated.
     * @param version Optional version reference. Defaults to the latest version.
     * @param request the updated agent configuration (all fields optional).
     * @return the updated agent.
     */
    @PatchExchange("/update-agent/{agent_id}")
    AgentResponse updateAgent(
            @PathVariable("agent_id") String agentId,
            @RequestParam(name = "version", required = false) String version,
            @RequestBody AgentRequest request);

    /**
     * Delete an existing agent.
     *
     * @param agentId Unique id of the agent to be deleted.
     */
    @DeleteExchange("/delete-agent/{agent_id}")
    void deleteAgent(@PathVariable("agent_id") String agentId);
}
