package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.Paginated;
import io.github.qaiserarbi.retellai.model.llm.CreateRetellLlmRequest;
import io.github.qaiserarbi.retellai.model.llm.RetellLLMResponse;
import io.github.qaiserarbi.retellai.model.llm.UpdateRetellLlmRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/** HTTP interface for the Retell AI Retell LLM response engine endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface RetellLlmApi {

    /**
     * Create a new Retell LLM response engine.
     *
     * @param request the Retell LLM configuration.
     * @return the created Retell LLM response engine.
     */
    @PostExchange("/create-retell-llm")
    RetellLLMResponse createRetellLLM(@RequestBody CreateRetellLlmRequest request);

    /**
     * Retrieve details of a specific Retell LLM response engine.
     *
     * @param llmId unique id of the Retell LLM response engine.
     * @return the Retell LLM response engine.
     */
    @GetExchange("/get-retell-llm/{llm_id}")
    RetellLLMResponse getRetellLLM(@PathVariable("llm_id") String llmId);

    /**
     * List all Retell LLM response engines (deprecated; prefer {@link #listRetellLLMV2}).
     *
     * @param limit                 maximum number of objects to return (1-1000, default 1000).
     * @param paginationKey         pagination key (llm id) to continue from.
     * @param paginationKeyVersion  version of the llm associated with the pagination key.
     * @return all Retell LLM response engines.
     */
    @GetExchange("/list-retell-llms")
    List<RetellLLMResponse> listRetellLLM(
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "pagination_key", required = false) String paginationKey,
            @RequestParam(value = "pagination_key_version", required = false) Integer paginationKeyVersion);

    /**
     * List Retell LLM response engines with pagination.
     *
     * @param limit         maximum number of items to return (max 1000, default 50).
     * @param sortOrder     sort order for results (ascending or descending, default descending).
     * @param paginationKey pagination key for fetching the next page.
     * @return a page of Retell LLM response engines.
     */
    @GetExchange("/v2/list-retell-llms")
    Paginated<RetellLLMResponse> listRetellLLMV2(
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "sort_order", required = false) String sortOrder,
            @RequestParam(value = "pagination_key", required = false) String paginationKey);

    /**
     * Update an existing Retell LLM response engine.
     *
     * @param llmId   unique id of the Retell LLM response engine to update.
     * @param version optional version to use for this request (defaults to latest).
     * @param request the update payload.
     * @return the updated Retell LLM response engine.
     */
    @PatchExchange("/update-retell-llm/{llm_id}")
    RetellLLMResponse updateRetellLLM(
            @PathVariable("llm_id") String llmId,
            @RequestParam(value = "version", required = false) Integer version,
            @RequestBody UpdateRetellLlmRequest request);

    /**
     * Delete a Retell LLM response engine (all versions).
     *
     * @param llmId unique id of the Retell LLM response engine to delete.
     */
    @DeleteExchange("/delete-retell-llm/{llm_id}")
    void deleteRetellLLM(@PathVariable("llm_id") String llmId);
}
