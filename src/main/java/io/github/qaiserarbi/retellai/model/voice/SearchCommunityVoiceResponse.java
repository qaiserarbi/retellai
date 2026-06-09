package io.github.qaiserarbi.retellai.model.voice;

import java.util.List;

/**
 * Response for a community voice search.
 *
 * @param voices Voices retrieved from the provider.
 */
public record SearchCommunityVoiceResponse(
        List<CommunityVoice> voices
) {}
