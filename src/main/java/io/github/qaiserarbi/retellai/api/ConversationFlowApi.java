package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.Paginated;
import io.github.qaiserarbi.retellai.model.conversationflow.ConversationFlow;
import io.github.qaiserarbi.retellai.model.conversationflow.ConversationFlowResponse;
import io.github.qaiserarbi.retellai.model.conversationflow.CreateConversationFlowRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/** HTTP interface for the Retell AI Conversation Flow endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface ConversationFlowApi {

    /**
     * Create a new conversation flow that can be attached to an agent.
     *
     * @param request the conversation flow configuration.
     * @return the created conversation flow.
     */
    @PostExchange("/create-conversation-flow")
    ConversationFlowResponse createConversationFlow(@RequestBody CreateConversationFlowRequest request);

    /**
     * Retrieve details of a specific conversation flow.
     *
     * @param conversationFlowId Unique id of the conversation flow to be retrieved.
     * @param version            Optional version to retrieve. Defaults to the latest version.
     * @return the conversation flow details.
     */
    @GetExchange("/get-conversation-flow/{conversation_flow_id}")
    ConversationFlowResponse getConversationFlow(
            @PathVariable("conversation_flow_id") String conversationFlowId,
            @RequestParam(name = "version", required = false) Integer version);

    /**
     * List all conversation flows that can be attached to an agent.
     *
     * @param limit                Limit the number of conversation flows returned (max 1000).
     * @param paginationKey        Pagination key (a conversation flow id) to continue fetching.
     * @param paginationKeyVersion Version of the conversation flow associated with the
     *                             pagination key.
     * @return all conversation flows.
     * @deprecated use {@link #listConversationFlowsV2} instead.
     */
    @Deprecated
    @GetExchange("/list-conversation-flows")
    List<ConversationFlowResponse> listConversationFlows(
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "pagination_key", required = false) String paginationKey,
            @RequestParam(name = "pagination_key_version", required = false) Integer paginationKeyVersion);

    /**
     * List conversation flows with pagination.
     *
     * @param limit         Maximum number of items to return.
     * @param sortOrder     Sort order ({@code ascending} or {@code descending}).
     * @param paginationKey Pagination key for fetching the next page.
     * @return a page of conversation flows.
     */
    @GetExchange("/v2/list-conversation-flows")
    Paginated<ConversationFlowResponse> listConversationFlowsV2(
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "sort_order", required = false) String sortOrder,
            @RequestParam(name = "pagination_key", required = false) String paginationKey);

    /**
     * Update an existing conversation flow.
     *
     * @param conversationFlowId Unique id of the conversation flow to be updated.
     * @param version            Optional version to update. Defaults to the latest version.
     * @param request            the updated conversation flow configuration.
     * @return the updated conversation flow.
     */
    @PatchExchange("/update-conversation-flow/{conversation_flow_id}")
    ConversationFlowResponse updateConversationFlow(
            @PathVariable("conversation_flow_id") String conversationFlowId,
            @RequestParam(name = "version", required = false) Integer version,
            @RequestBody ConversationFlow request);

    /**
     * Delete a conversation flow and all its versions.
     *
     * @param conversationFlowId Unique id of the conversation flow to be deleted.
     */
    @DeleteExchange("/delete-conversation-flow/{conversation_flow_id}")
    void deleteConversationFlow(@PathVariable("conversation_flow_id") String conversationFlowId);
}
