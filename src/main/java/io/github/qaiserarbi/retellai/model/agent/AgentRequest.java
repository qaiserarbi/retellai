package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.PostCallAnalysisData;
import io.github.qaiserarbi.retellai.model.common.ResponseEngine;

import java.util.List;

/**
 * Configuration payload for creating or updating an agent. All fields are optional;
 * for {@code createAgent}, {@code responseEngine} and {@code voiceId} are required by
 * the API. Reused for both create and update (PATCH) operations.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentRequest(
        ResponseEngine responseEngine,
        String agentName,
        String versionDescription,
        String voiceId,
        VoiceModel voiceModel,
        List<String> fallbackVoiceIds,
        Double voiceTemperature,
        Double voiceSpeed,
        Boolean enableDynamicVoiceSpeed,
        Boolean enableDynamicResponsiveness,
        Double volume,
        VoiceEmotion voiceEmotion,
        Double responsiveness,
        Double interruptionSensitivity,
        Boolean enableBackchannel,
        Double backchannelFrequency,
        List<String> backchannelWords,
        Double reminderTriggerMs,
        Integer reminderMaxCount,
        AmbientSound ambientSound,
        Double ambientSoundVolume,
        AgentLanguage language,
        String webhookUrl,
        List<WebhookEvent> webhookEvents,
        Integer webhookTimeoutMs,
        List<String> boostedKeywords,
        DataStorageSetting dataStorageSetting,
        Integer dataStorageRetentionDays,
        Boolean optInSignedUrl,
        Integer signedUrlExpirationMs,
        List<PronunciationEntry> pronunciationDictionary,
        Integer endCallAfterSilenceMs,
        Integer maxCallDurationMs,
        String voicemailMessage,
        Integer voicemailDetectionTimeoutMs,
        VoicemailOption voicemailOption,
        IvrOption ivrOption,
        CallScreeningOption callScreeningOption,
        List<PostCallAnalysisData> postCallAnalysisData,
        LlmModel postCallAnalysisModel,
        String analysisSuccessfulPrompt,
        String analysisSummaryPrompt,
        String analysisUserSentimentPrompt,
        Integer beginMessageDelayMs,
        Integer ringDurationMs,
        SttMode sttMode,
        CustomSttConfig customSttConfig,
        VocabSpecialization vocabSpecialization,
        Boolean allowUserDtmf,
        Boolean allowDtmfInterruption,
        UserDtmfOptions userDtmfOptions,
        DenoisingMode denoisingMode,
        PIIConfig piiConfig,
        GuardrailConfig guardrailConfig,
        VoiceHandbookConfig handbookConfig,
        String timezone
) {
}
