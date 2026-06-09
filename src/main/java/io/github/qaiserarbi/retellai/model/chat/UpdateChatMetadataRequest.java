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
}
