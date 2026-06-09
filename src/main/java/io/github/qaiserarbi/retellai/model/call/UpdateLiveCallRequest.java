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
