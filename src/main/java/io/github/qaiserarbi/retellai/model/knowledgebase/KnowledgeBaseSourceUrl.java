package io.github.qaiserarbi.retellai.model.knowledgebase;

/**
 * A knowledge base source backed by a scraped URL.
 *
 * @param sourceId unique id of the knowledge base source
 * @param url      URL used to be scraped and added to the knowledge base
 */
public record KnowledgeBaseSourceUrl(
    String sourceId,
    String url
) implements KnowledgeBaseSource {
}
