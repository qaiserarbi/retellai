package io.github.qaiserarbi.retellai.model.knowledgebase;

/**
 * A knowledge base source backed by an uploaded document.
 *
 * @param sourceId unique id of the knowledge base source
 * @param filename filename of the document
 * @param fileUrl  URL of the document stored
 * @param fileSize file size in bytes
 */
public record KnowledgeBaseSourceDocument(
    String sourceId,
    String filename,
    String fileUrl,
    Double fileSize
) implements KnowledgeBaseSource {
}
