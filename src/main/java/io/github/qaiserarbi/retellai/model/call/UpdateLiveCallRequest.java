package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * Request body for updating an ongoing call at runtime.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateLiveCallRequest(
        FieldsToOverride fieldsToOverride,
        CallControl callControl) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link UpdateLiveCallRequest}. */
    public static final class Builder {
        private FieldsToOverride fieldsToOverride;
        private CallControl callControl;

        private Builder() {
        }

        public Builder fieldsToOverride(FieldsToOverride fieldsToOverride) {
            this.fieldsToOverride = fieldsToOverride;
            return this;
        }

        public Builder callControl(CallControl callControl) {
            this.callControl = callControl;
            return this;
        }

        public UpdateLiveCallRequest build() {
            return new UpdateLiveCallRequest(fieldsToOverride, callControl);
        }
    }

    /** Call fields to override on the running call. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record FieldsToOverride(
            Map<String, String> overrideDynamicVariables,
            Map<String, Object> metadata,
            DataStorageSetting dataStorageSetting) {
    }

    /** Live agent control. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CallControl(
            Boolean triggerResponse,
            String additionalContext) {
    }
}
