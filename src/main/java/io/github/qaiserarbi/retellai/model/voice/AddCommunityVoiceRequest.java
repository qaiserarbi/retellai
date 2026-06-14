package io.github.qaiserarbi.retellai.model.voice;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Request body for adding a community voice to the voice library.
 *
 * @param voiceProvider   Voice provider to add the voice from.
 * @param providerVoiceId Voice id assigned by the provider.
 * @param voiceName       A custom name for the voice.
 * @param publicUserId    Required for ElevenLabs only. User id of the voice owner.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AddCommunityVoiceRequest(
        CommunityVoiceProvider voiceProvider,
        String providerVoiceId,
        String voiceName,
        String publicUserId
) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link AddCommunityVoiceRequest}. */
    public static final class Builder {
        private CommunityVoiceProvider voiceProvider;
        private String providerVoiceId;
        private String voiceName;
        private String publicUserId;

        private Builder() {
        }

        public Builder voiceProvider(CommunityVoiceProvider voiceProvider) {
            this.voiceProvider = voiceProvider;
            return this;
        }

        public Builder providerVoiceId(String providerVoiceId) {
            this.providerVoiceId = providerVoiceId;
            return this;
        }

        public Builder voiceName(String voiceName) {
            this.voiceName = voiceName;
            return this;
        }

        public Builder publicUserId(String publicUserId) {
            this.publicUserId = publicUserId;
            return this;
        }

        public AddCommunityVoiceRequest build() {
            return new AddCommunityVoiceRequest(voiceProvider, providerVoiceId, voiceName, publicUserId);
        }
    }
}
