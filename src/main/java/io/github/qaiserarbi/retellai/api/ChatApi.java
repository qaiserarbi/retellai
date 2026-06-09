package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.chat.ChatResponse;
import io.github.qaiserarbi.retellai.model.chat.CreateChatCompletionRequest;
import io.github.qaiserarbi.retellai.model.chat.CreateChatCompletionResponse;
import io.github.qaiserarbi.retellai.model.chat.CreateChatRequest;
import io.github.qaiserarbi.retellai.model.chat.ListChatsV3Request;
import io.github.qaiserarbi.retellai.model.chat.UpdateChatMetadataRequest;
import io.github.qaiserarbi.retellai.model.chat.V3ChatResponse;
import io.github.qaiserarbi.retellai.model.common.Paginated;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

/** HTTP interface for the Retell AI Chat endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface ChatApi {

    /**
     * Create a chat session.
     *
     * @param request the create chat request.
     * @return the created chat.
     */
    @PostExchange("/create-chat")
    ChatResponse createChat(@RequestBody CreateChatRequest request);

    /**
     * Retrieve details of a specific chat.
     *
     * @param chatId unique id of the chat.
     * @return the chat details.
     */
    @GetExchange("/get-chat/{chat_id}")
    ChatResponse getChat(@PathVariable("chat_id") String chatId);

    /**
     * List all chats (deprecated). Returns a bare array of chats.
     *
     * @return all chats.
     * @deprecated use {@link #listChatsV3(ListChatsV3Request)} instead.
     */
    @Deprecated
    @GetExchange("/list-chat")
    List<ChatResponse> listChat();

    /**
     * List chats with unified cursor pagination response.
     *
     * @param request the list chats request.
     * @return a paginated page of chats.
     */
    @PostExchange("/v3/list-chats")
    Paginated<V3ChatResponse> listChatsV3(@RequestBody ListChatsV3Request request);

    /**
     * Update metadata and data storage settings for an existing chat.
     *
     * @param chatId  the chat id to update.
     * @param request the update request.
     * @return the updated chat.
     */
    @PatchExchange("/update-chat/{chat_id}")
    ChatResponse updateChatMetadata(
            @PathVariable("chat_id") String chatId,
            @RequestBody UpdateChatMetadataRequest request);

    /**
     * Delete an existing chat.
     *
     * @param chatId unique id of the chat to delete.
     */
    @DeleteExchange("/delete-chat/{chat_id}")
    void deleteChat(@PathVariable("chat_id") String chatId);

    /**
     * End an ongoing chat.
     *
     * @param chatId unique id of the chat to end.
     */
    @PatchExchange("/end-chat/{chat_id}")
    void endChat(@PathVariable("chat_id") String chatId);

    /**
     * Create a chat completion message.
     *
     * @param request the create chat completion request.
     * @return the newly generated messages, including any tool calls and results.
     */
    @PostExchange("/create-chat-completion")
    CreateChatCompletionResponse createChatCompletion(@RequestBody CreateChatCompletionRequest request);

    /**
     * Rerun post-chat analysis for a specific chat.
     *
     * @param chatId unique id of the chat to rerun analysis for.
     * @return the chat with refreshed analysis.
     */
    @PutExchange("/rerun-chat-analysis/{chat_id}")
    ChatResponse rerunChatAnalysis(@PathVariable("chat_id") String chatId);
}
