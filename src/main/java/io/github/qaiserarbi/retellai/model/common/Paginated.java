package io.github.qaiserarbi.retellai.model.common;

import java.util.List;

/**
 * Generic wrapper for paginated list responses, mirroring {@code PaginatedResponseBase} plus the
 * per-endpoint {@code items} array. To fetch the next page, pass {@link #paginationKey()} back as
 * the {@code pagination_key} request parameter; {@link #hasMore()} indicates whether more remain.
 *
 * @param items         the page of results (wire field {@code items}).
 * @param paginationKey pagination key for the next page, or {@code null} on the last page.
 * @param hasMore       whether more results are available.
 * @param total         total number of matching records; only present when the request asked for it.
 * @param <T>           the element type.
 */
public record Paginated<T>(
        List<T> items,
        String paginationKey,
        Boolean hasMore,
        Integer total
) {
}
