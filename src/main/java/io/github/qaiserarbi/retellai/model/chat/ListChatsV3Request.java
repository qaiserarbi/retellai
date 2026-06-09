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
}
