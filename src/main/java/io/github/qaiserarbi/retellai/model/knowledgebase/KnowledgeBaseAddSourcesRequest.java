package io.github.qaiserarbi.retellai.model.knowledgebase;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Request to add sources to an existing knowledge base. Sent as
 * {@code multipart/form-data}.
 * <p>
 * File parts ({@code knowledge_base_files}) are not represented here; they are
 * passed separately as {@code MultipartFile}/{@code Resource} {@code @RequestPart}
 * parameters on the API method.
 *
 * @param knowledgeBaseTexts texts to add to the knowledge base
 * @param knowledgeBaseUrls  URLs to be scraped and added to the knowledge base
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record KnowledgeBaseAddSourcesRequest(
    List<KnowledgeBaseTextSource> knowledgeBaseTexts,
    List<String> knowledgeBaseUrls
) {
}
