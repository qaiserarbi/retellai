package io.github.qaiserarbi.retellai.model.knowledgebase;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Request to create a new knowledge base. Sent as {@code multipart/form-data}.
 * <p>
 * File parts ({@code knowledge_base_files}) are not represented here; they are
 * passed separately as {@code MultipartFile}/{@code Resource} {@code @RequestPart}
 * parameters on the API method.
 *
 * @param knowledgeBaseName  name of the knowledge base (must be less than 40 characters)
 * @param knowledgeBaseTexts texts to add to the knowledge base
 * @param knowledgeBaseUrls  URLs to be scraped and added to the knowledge base
 * @param enableAutoRefresh  whether to enable auto refresh for the knowledge base urls
 * @param maxChunkSize       maximum number of characters per chunk (600-6000, immutable after creation)
 * @param minChunkSize       minimum number of characters per chunk (200-2000, immutable after creation)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record KnowledgeBaseRequest(
    String knowledgeBaseName,
    List<KnowledgeBaseTextSource> knowledgeBaseTexts,
    List<String> knowledgeBaseUrls,
    Boolean enableAutoRefresh,
    Integer maxChunkSize,
    Integer minChunkSize
) {
}
