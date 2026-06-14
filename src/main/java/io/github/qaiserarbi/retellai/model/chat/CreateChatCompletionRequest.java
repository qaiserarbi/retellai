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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateChatCompletionRequest}. */
    public static final class Builder {
        private String chatId;
        private String content;

        private Builder() {
        }

        public Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public CreateChatCompletionRequest build() {
            return new CreateChatCompletionRequest(chatId, content);
        }
    }
}
