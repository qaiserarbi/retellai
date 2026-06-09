package io.github.qaiserarbi.retellai.model.knowledgebase;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * A source belonging to a knowledge base. The concrete variant is discriminated
 * by the {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = KnowledgeBaseSourceDocument.class, name = "document"),
    @JsonSubTypes.Type(value = KnowledgeBaseSourceText.class, name = "text"),
    @JsonSubTypes.Type(value = KnowledgeBaseSourceUrl.class, name = "url")
})
public sealed interface KnowledgeBaseSource
    permits KnowledgeBaseSourceDocument, KnowledgeBaseSourceText, KnowledgeBaseSourceUrl {
}
