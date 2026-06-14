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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link KnowledgeBaseRequest}. */
    public static final class Builder {
        private String knowledgeBaseName;
        private List<KnowledgeBaseTextSource> knowledgeBaseTexts;
        private List<String> knowledgeBaseUrls;
        private Boolean enableAutoRefresh;
        private Integer maxChunkSize;
        private Integer minChunkSize;

        private Builder() {
        }

        public Builder knowledgeBaseName(String knowledgeBaseName) {
            this.knowledgeBaseName = knowledgeBaseName;
            return this;
        }

        public Builder knowledgeBaseTexts(List<KnowledgeBaseTextSource> knowledgeBaseTexts) {
            this.knowledgeBaseTexts = knowledgeBaseTexts;
            return this;
        }

        public Builder knowledgeBaseUrls(List<String> knowledgeBaseUrls) {
            this.knowledgeBaseUrls = knowledgeBaseUrls;
            return this;
        }

        public Builder enableAutoRefresh(Boolean enableAutoRefresh) {
            this.enableAutoRefresh = enableAutoRefresh;
            return this;
        }

        public Builder maxChunkSize(Integer maxChunkSize) {
            this.maxChunkSize = maxChunkSize;
            return this;
        }

        public Builder minChunkSize(Integer minChunkSize) {
            this.minChunkSize = minChunkSize;
            return this;
        }

        public KnowledgeBaseRequest build() {
            return new KnowledgeBaseRequest(knowledgeBaseName, knowledgeBaseTexts, knowledgeBaseUrls, enableAutoRefresh, maxChunkSize, minChunkSize);
        }
    }
}
