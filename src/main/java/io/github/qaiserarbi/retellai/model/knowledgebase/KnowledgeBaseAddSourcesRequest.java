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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link KnowledgeBaseAddSourcesRequest}. */
    public static final class Builder {
        private List<KnowledgeBaseTextSource> knowledgeBaseTexts;
        private List<String> knowledgeBaseUrls;

        private Builder() {
        }

        public Builder knowledgeBaseTexts(List<KnowledgeBaseTextSource> knowledgeBaseTexts) {
            this.knowledgeBaseTexts = knowledgeBaseTexts;
            return this;
        }

        public Builder knowledgeBaseUrls(List<String> knowledgeBaseUrls) {
            this.knowledgeBaseUrls = knowledgeBaseUrls;
            return this;
        }

        public KnowledgeBaseAddSourcesRequest build() {
            return new KnowledgeBaseAddSourcesRequest(knowledgeBaseTexts, knowledgeBaseUrls);
        }
    }
}
