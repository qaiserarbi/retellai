package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import io.github.qaiserarbi.retellai.model.test.AgentPlaygroundCompletionRequest;
import io.github.qaiserarbi.retellai.model.test.AgentPlaygroundCompletionResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/** HTTP interface for Retell agent playground operations. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface PlaygroundApi {

    /**
     * Stateless playground completion. Send the full conversation history and
     * receive only the newly generated messages. Nothing is persisted server-side.
     */
    @PostExchange("/agent-playground-completion/{agent_id}")
    AgentPlaygroundCompletionResponse agentPlaygroundCompletion(
            @PathVariable("agent_id") String agentId,
            @RequestBody AgentPlaygroundCompletionRequest request,
            @RequestParam(name = "version", required = false) AgentVersionReference version);
}
