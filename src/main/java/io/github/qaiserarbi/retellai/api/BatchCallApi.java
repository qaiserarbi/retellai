package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.call.BatchCallResponse;
import io.github.qaiserarbi.retellai.model.call.CreateBatchCallRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/** HTTP interface for Retell batch call operations. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface BatchCallApi {

    /** Create a batch call. */
    @PostExchange("/create-batch-call")
    BatchCallResponse createBatchCall(@RequestBody CreateBatchCallRequest request);
}
