package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.chat.ChatResponse;
import io.github.qaiserarbi.retellai.model.chat.CreateSmsChatRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/** HTTP interface for the Retell AI SMS chat endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface SmsApi {

    /**
     * Create an SMS chat and send the initial message.
     *
     * @param request the create SMS chat request.
     * @return the created chat.
     */
    @PostExchange("/create-sms-chat")
    ChatResponse createSmsChat(@RequestBody CreateSmsChatRequest request);
}
