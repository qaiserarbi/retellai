package io.github.qaiserarbi.retellai.model.knowledgebase;

import java.util.List;

/**
 * A knowledge base resource.
 *
 * @param knowledgeBaseId         unique id of the knowledge base
 * @param knowledgeBaseName       name of the knowledge base
 * @param status                  status of the knowledge base
 * @param maxChunkSize            maximum number of characters per chunk when splitting content
 * @param minChunkSize            minimum number of characters per chunk
 * @param knowledgeBaseSources    sources of the knowledge base (populated once processing is done)
 * @param enableAutoRefresh       whether auto refresh is enabled for the knowledge base urls
 * @param lastRefreshedTimestamp  last refreshed timestamp (milliseconds since epoch)
 */
public record KnowledgeBaseResponse(
    String knowledgeBaseId,
    String knowledgeBaseName,
    KnowledgeBaseStatus status,
    Integer maxChunkSize,
    Integer minChunkSize,
    List<KnowledgeBaseSource> knowledgeBaseSources,
    Boolean enableAutoRefresh,
    Long lastRefreshedTimestamp
) {
}
