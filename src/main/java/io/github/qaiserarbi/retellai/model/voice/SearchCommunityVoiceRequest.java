package io.github.qaiserarbi.retellai.model.voice;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Request body for searching community voices from voice providers.
 *
 * @param voiceProvider Voice provider to search.
 * @param searchQuery   Search query to find voices by name, description, or ID.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SearchCommunityVoiceRequest(
        CommunityVoiceProvider voiceProvider,
        String searchQuery
) {}
