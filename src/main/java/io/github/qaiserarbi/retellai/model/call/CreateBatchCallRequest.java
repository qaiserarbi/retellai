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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateBatchCallRequest}. */
    public static final class Builder {
        private String name;
        private Long triggerTimestamp;
        private String fromNumber;
        private Integer reservedConcurrency;
        private List<BatchCallTask> tasks;
        private CallTimeWindow callTimeWindow;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder triggerTimestamp(Long triggerTimestamp) {
            this.triggerTimestamp = triggerTimestamp;
            return this;
        }

        public Builder fromNumber(String fromNumber) {
            this.fromNumber = fromNumber;
            return this;
        }

        public Builder reservedConcurrency(Integer reservedConcurrency) {
            this.reservedConcurrency = reservedConcurrency;
            return this;
        }

        public Builder tasks(List<BatchCallTask> tasks) {
            this.tasks = tasks;
            return this;
        }

        public Builder callTimeWindow(CallTimeWindow callTimeWindow) {
            this.callTimeWindow = callTimeWindow;
            return this;
        }

        public CreateBatchCallRequest build() {
            return new CreateBatchCallRequest(name, triggerTimestamp, fromNumber, reservedConcurrency, tasks, callTimeWindow);
        }
    }
}
