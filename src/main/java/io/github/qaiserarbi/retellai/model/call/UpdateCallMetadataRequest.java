package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * Request body for updating metadata and sensitive data storage settings for an
 * existing call.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateCallMetadataRequest(
        Map<String, Object> metadata,
        DataStorageSetting dataStorageSetting,
        Map<String, String> overrideDynamicVariables,
        Map<String, Object> customAttributes) {
}
