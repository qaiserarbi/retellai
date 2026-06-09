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
) {}
