package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.Paginated;
import io.github.qaiserarbi.retellai.model.misc.ExportRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * Operations for listing data export requests.
 */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface ExportApi {

    /**
     * List export requests with pagination.
     *
     * @param limit         maximum number of items to return.
     * @param sortOrder     sort order for results ({@code ascending} or {@code descending}).
     * @param paginationKey pagination key for fetching the next page.
     * @return a paginated page of export requests.
     */
    @GetExchange("/v2/list-export-requests")
    Paginated<ExportRequest> listExportRequests(
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "sort_order", required = false) String sortOrder,
            @RequestParam(name = "pagination_key", required = false) String paginationKey);
}
