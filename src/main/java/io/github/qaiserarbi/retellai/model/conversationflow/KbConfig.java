package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Knowledge base configuration for RAG retrieval.
 *
 * @param topK        max number of knowledge base chunks to retrieve (1-10).
 * @param filterScore similarity threshold for filtering search results (0-1).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record KbConfig(
        Integer topK,
        Double filterScore
) {
}
