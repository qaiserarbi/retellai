package io.github.qaiserarbi.retellai.model.knowledgebase;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A free-form text entry to add to a knowledge base.
 *
 * @param title title of the text
 * @param text  text to add to the knowledge base
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record KnowledgeBaseTextSource(
    String title,
    String text
) {
}
