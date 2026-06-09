package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * Request body for the deprecated v2 list-calls endpoint. The
 * {@code filterCriteria} field accepts the loosely-typed v2 filter object
 * (including dot-notation keys such as {@code metadata.customer_id}).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ListCallsRequest(
        Map<String, Object> filterCriteria,
        SortOrder sortOrder,
        Integer limit,
        String paginationKey) {
}
