package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;

/** Request body for listing calls with unified cursor pagination. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record V3ListCallsRequest(
        CallFilter filterCriteria,
        SortOrder sortOrder,
        Integer limit,
        Integer skip,
        String paginationKey,
        Boolean includeTotal) {
}
