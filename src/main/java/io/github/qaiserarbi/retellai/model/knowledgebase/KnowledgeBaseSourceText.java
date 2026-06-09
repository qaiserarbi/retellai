package io.github.qaiserarbi.retellai.model.knowledgebase;

/**
 * A knowledge base source backed by a free-form text snippet.
 *
 * @param sourceId   unique id of the knowledge base source
 * @param title      title of the text
 * @param contentUrl URL of the text content stored
 */
public record KnowledgeBaseSourceText(
    String sourceId,
    String title,
    String contentUrl
) implements KnowledgeBaseSource {
}
