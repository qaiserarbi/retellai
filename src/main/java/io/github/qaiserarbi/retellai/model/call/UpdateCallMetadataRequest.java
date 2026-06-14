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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link UpdateCallMetadataRequest}. */
    public static final class Builder {
        private Map<String, Object> metadata;
        private DataStorageSetting dataStorageSetting;
        private Map<String, String> overrideDynamicVariables;
        private Map<String, Object> customAttributes;

        private Builder() {
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder dataStorageSetting(DataStorageSetting dataStorageSetting) {
            this.dataStorageSetting = dataStorageSetting;
            return this;
        }

        public Builder overrideDynamicVariables(Map<String, String> overrideDynamicVariables) {
            this.overrideDynamicVariables = overrideDynamicVariables;
            return this;
        }

        public Builder customAttributes(Map<String, Object> customAttributes) {
            this.customAttributes = customAttributes;
            return this;
        }

        public UpdateCallMetadataRequest build() {
            return new UpdateCallMetadataRequest(metadata, dataStorageSetting, overrideDynamicVariables, customAttributes);
        }
    }
}
