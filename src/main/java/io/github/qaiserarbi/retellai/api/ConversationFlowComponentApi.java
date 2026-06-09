package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.Paginated;
import io.github.qaiserarbi.retellai.model.conversationflow.ConversationFlowComponent;
import io.github.qaiserarbi.retellai.model.conversationflow.ConversationFlowComponentResponse;
import io.github.qaiserarbi.retellai.model.conversationflow.CreateConversationFlowComponentRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/** HTTP interface for the Retell AI shared Conversation Flow Component endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface ConversationFlowComponentApi {

    /**
     * Create a new shared conversation flow component.
     *
     * @param request the component configuration.
     * @return the created component.
     */
    @PostExchange("/create-conversation-flow-component")
    ConversationFlowComponentResponse createConversationFlowComponent(
            @RequestBody CreateConversationFlowComponentRequest request);

    /**
     * Get a shared conversation flow component.
     *
     * @param conversationFlowComponentId ID of the component to retrieve.
     * @return the component.
     */
    @GetExchange("/get-conversation-flow-component/{conversation_flow_component_id}")
    ConversationFlowComponentResponse getConversationFlowComponent(
            @PathVariable("conversation_flow_component_id") String conversationFlowComponentId);

    /**
     * List shared conversation flow components.
     *
     * @return all shared components.
     * @deprecated use {@link #listConversationFlowComponentsV2} instead.
     */
    @Deprecated
    @GetExchange("/list-conversation-flow-components")
    List<ConversationFlowComponentResponse> listConversationFlowComponents();

    /**
     * List shared conversation flow components with pagination.
     *
     * @param limit         Maximum number of items to return.
     * @param sortOrder     Sort order ({@code ascending} or {@code descending}).
     * @param paginationKey Pagination key for fetching the next page.
     * @return a page of shared components.
     */
    @GetExchange("/v2/list-conversation-flow-components")
    Paginated<ConversationFlowComponentResponse> listConversationFlowComponentsV2(
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "sort_order", required = false) String sortOrder,
            @RequestParam(name = "pagination_key", required = false) String paginationKey);

    /**
     * Update an existing shared conversation flow component.
     *
     * @param conversationFlowComponentId ID of the component to update.
     * @param request                     the updated component configuration.
     * @return the updated component.
     */
    @PatchExchange("/update-conversation-flow-component/{conversation_flow_component_id}")
    ConversationFlowComponentResponse updateConversationFlowComponent(
            @PathVariable("conversation_flow_component_id") String conversationFlowComponentId,
            @RequestBody ConversationFlowComponent request);

    /**
     * Delete a shared conversation flow component. Creates local copies for all linked
     * conversation flows.
     *
     * @param conversationFlowComponentId ID of the component to delete.
     */
    @DeleteExchange("/delete-conversation-flow-component/{conversation_flow_component_id}")
    void deleteConversationFlowComponent(
            @PathVariable("conversation_flow_component_id") String conversationFlowComponentId);
}
