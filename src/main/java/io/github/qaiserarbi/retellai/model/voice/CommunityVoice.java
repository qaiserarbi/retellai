package io.github.qaiserarbi.retellai.model.voice;

/**
 * A community voice retrieved from a provider.
 *
 * @param providerVoiceId id of the voice from the provider.
 * @param name            Name of the voice.
 * @param description     Description of the voice.
 * @param publicUserId    For ElevenLabs only. User id of the voice owner.
 */
public record CommunityVoice(
        String providerVoiceId,
        String name,
        String description,
        String publicUserId
) {}
