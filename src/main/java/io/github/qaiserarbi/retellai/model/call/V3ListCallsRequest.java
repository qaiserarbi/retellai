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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link V3ListCallsRequest}. */
    public static final class Builder {
        private CallFilter filterCriteria;
        private SortOrder sortOrder;
        private Integer limit;
        private Integer skip;
        private String paginationKey;
        private Boolean includeTotal;

        private Builder() {
        }

        public Builder filterCriteria(CallFilter filterCriteria) {
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

        public Builder skip(Integer skip) {
            this.skip = skip;
            return this;
        }

        public Builder paginationKey(String paginationKey) {
            this.paginationKey = paginationKey;
            return this;
        }

        public Builder includeTotal(Boolean includeTotal) {
            this.includeTotal = includeTotal;
            return this;
        }

        public V3ListCallsRequest build() {
            return new V3ListCallsRequest(filterCriteria, sortOrder, limit, skip, paginationKey, includeTotal);
        }
    }
}
