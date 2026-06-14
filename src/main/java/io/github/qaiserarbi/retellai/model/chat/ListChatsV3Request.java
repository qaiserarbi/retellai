package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Request body for listing chats with unified cursor pagination.
 *
 * @param filterCriteria filter criteria for chats to retrieve.
 * @param sortOrder      sort chats by {@code start_timestamp} ascending or descending.
 * @param limit          maximum number of chats to return.
 * @param skip           number of records to skip for pagination.
 * @param paginationKey  opaque pagination cursor from a previous response.
 * @param includeTotal   whether to include {@code total} in the response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ListChatsV3Request(
        ChatFilter filterCriteria,
        ChatSortOrder sortOrder,
        Integer limit,
        Integer skip,
        String paginationKey,
        Boolean includeTotal) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link ListChatsV3Request}. */
    public static final class Builder {
        private ChatFilter filterCriteria;
        private ChatSortOrder sortOrder;
        private Integer limit;
        private Integer skip;
        private String paginationKey;
        private Boolean includeTotal;

        private Builder() {
        }

        public Builder filterCriteria(ChatFilter filterCriteria) {
            this.filterCriteria = filterCriteria;
            return this;
        }

        public Builder sortOrder(ChatSortOrder sortOrder) {
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

        public ListChatsV3Request build() {
            return new ListChatsV3Request(filterCriteria, sortOrder, limit, skip, paginationKey,
                    includeTotal);
        }
    }
}
