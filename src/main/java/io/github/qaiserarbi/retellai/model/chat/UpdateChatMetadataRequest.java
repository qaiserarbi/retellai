package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * Request body for updating metadata and data storage settings of an existing chat.
 *
 * @param metadata                  arbitrary storage-only object (max 50kB).
 * @param dataStorageSetting        data storage setting for this chat ({@code everything} or
 *                                  {@code basic_attributes_only}); overrides the agent default.
 * @param overrideDynamicVariables  override dynamic variables (delta only); null removes overrides.
 * @param customAttributes          custom attributes for the chat.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateChatMetadataRequest(
        Map<String, Object> metadata,
        String dataStorageSetting,
        Map<String, String> overrideDynamicVariables,
        Map<String, Object> customAttributes) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link UpdateChatMetadataRequest}. */
    public static final class Builder {
        private Map<String, Object> metadata;
        private String dataStorageSetting;
        private Map<String, String> overrideDynamicVariables;
        private Map<String, Object> customAttributes;

        private Builder() {
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder dataStorageSetting(String dataStorageSetting) {
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

        public UpdateChatMetadataRequest build() {
            return new UpdateChatMetadataRequest(metadata, dataStorageSetting,
                    overrideDynamicVariables, customAttributes);
        }
    }
}
