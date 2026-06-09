package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Request body for creating a chat completion message.
 *
 * @param chatId  unique id of the chat to create a completion for.
 * @param content user message to generate the agent chat completion.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateChatCompletionRequest(
        String chatId,
        String content) {
}
