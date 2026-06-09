package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.agent.AgentResponse;
import io.github.qaiserarbi.retellai.model.agent.CreateAgentVersionRequest;
import io.github.qaiserarbi.retellai.model.agent.PublishAgentVersionRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/** HTTP interface for the Retell AI Agent Version endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface AgentVersionApi {

    /**
     * Retrieve all versions of an agent.
     *
     * @param agentId Unique id of the agent whose versions are to be retrieved.
     * @return all versions of the agent.
     */
    @GetExchange("/get-agent-versions/{agent_id}")
    List<AgentResponse> getAgentVersions(@PathVariable("agent_id") String agentId);

    /**
     * Create a new draft agent version from a base version.
     *
     * @param agentId Unique id of the agent.
     * @param request the create version request specifying the base version.
     * @return the newly created draft version.
     */
    @PostExchange("/create-agent-version/{agent_id}")
    AgentResponse createAgentVersion(
            @PathVariable("agent_id") String agentId,
            @RequestBody CreateAgentVersionRequest request);

    /**
     * Publish an existing draft version in place.
     *
     * @param agentId Unique id of the agent.
     * @param request the publish request specifying the version to publish.
     */
    @PostExchange("/publish-agent-version/{agent_id}")
    void publishAgentVersion(
            @PathVariable("agent_id") String agentId,
            @RequestBody PublishAgentVersionRequest request);

    /**
     * Delete a specific agent version.
     *
     * @param agentId Unique id of the agent.
     * @param version Version to delete.
     */
    @DeleteExchange("/delete-agent-version/{agent_id}")
    void deleteAgentVersion(
            @PathVariable("agent_id") String agentId,
            @RequestParam("version") Integer version);
}
