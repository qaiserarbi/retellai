package io.github.qaiserarbi.retellai.model.voice;

/**
 * Details of a voice.
 *
 * @param voiceId         Unique id for the voice.
 * @param voiceName       Name of the voice.
 * @param provider        Provider of the voice.
 * @param accent          Accent annotation of the voice.
 * @param gender          Gender of the voice.
 * @param age             Age annotation of the voice.
 * @param previewAudioUrl URL to the preview audio of the voice.
 */
public record VoiceResponse(
        String voiceId,
        String voiceName,
        VoiceProvider provider,
        String accent,
        VoiceGender gender,
        String age,
        String previewAudioUrl
) {}
