package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/** Request body for creating a batch call. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateBatchCallRequest(
        String name,
        Long triggerTimestamp,
        String fromNumber,
        Integer reservedConcurrency,
        List<BatchCallTask> tasks,
        CallTimeWindow callTimeWindow) {
}
