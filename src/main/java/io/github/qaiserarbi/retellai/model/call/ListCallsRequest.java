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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link ListCallsRequest}. */
    public static final class Builder {
        private Map<String, Object> filterCriteria;
        private SortOrder sortOrder;
        private Integer limit;
        private String paginationKey;

        private Builder() {
        }

        public Builder filterCriteria(Map<String, Object> filterCriteria) {
            this.filterCriteria = filterCriteria;
            return this;
        }

        public Builder sortOrder(SortOrder sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder paginationKey(String paginationKey) {
            this.paginationKey = paginationKey;
            return this;
        }

        public ListCallsRequest build() {
            return new ListCallsRequest(filterCriteria, sortOrder, limit, paginationKey);
        }
    }
}
