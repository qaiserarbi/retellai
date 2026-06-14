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
) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link SearchCommunityVoiceRequest}. */
    public static final class Builder {
        private CommunityVoiceProvider voiceProvider;
        private String searchQuery;

        private Builder() {
        }

        public Builder voiceProvider(CommunityVoiceProvider voiceProvider) {
            this.voiceProvider = voiceProvider;
            return this;
        }

        public Builder searchQuery(String searchQuery) {
            this.searchQuery = searchQuery;
            return this;
        }

        public SearchCommunityVoiceRequest build() {
            return new SearchCommunityVoiceRequest(voiceProvider, searchQuery);
        }
    }
}
