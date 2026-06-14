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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link AgentRequest}. */
    public static final class Builder {
        private ResponseEngine responseEngine;
        private String agentName;
        private String versionDescription;
        private String voiceId;
        private VoiceModel voiceModel;
        private List<String> fallbackVoiceIds;
        private Double voiceTemperature;
        private Double voiceSpeed;
        private Boolean enableDynamicVoiceSpeed;
        private Boolean enableDynamicResponsiveness;
        private Double volume;
        private VoiceEmotion voiceEmotion;
        private Double responsiveness;
        private Double interruptionSensitivity;
        private Boolean enableBackchannel;
        private Double backchannelFrequency;
        private List<String> backchannelWords;
        private Double reminderTriggerMs;
        private Integer reminderMaxCount;
        private AmbientSound ambientSound;
        private Double ambientSoundVolume;
        private AgentLanguage language;
        private String webhookUrl;
        private List<WebhookEvent> webhookEvents;
        private Integer webhookTimeoutMs;
        private List<String> boostedKeywords;
        private DataStorageSetting dataStorageSetting;
        private Integer dataStorageRetentionDays;
        private Boolean optInSignedUrl;
        private Integer signedUrlExpirationMs;
        private List<PronunciationEntry> pronunciationDictionary;
        private Integer endCallAfterSilenceMs;
        private Integer maxCallDurationMs;
        private String voicemailMessage;
        private Integer voicemailDetectionTimeoutMs;
        private VoicemailOption voicemailOption;
        private IvrOption ivrOption;
        private CallScreeningOption callScreeningOption;
        private List<PostCallAnalysisData> postCallAnalysisData;
        private LlmModel postCallAnalysisModel;
        private String analysisSuccessfulPrompt;
        private String analysisSummaryPrompt;
        private String analysisUserSentimentPrompt;
        private Integer beginMessageDelayMs;
        private Integer ringDurationMs;
        private SttMode sttMode;
        private CustomSttConfig customSttConfig;
        private VocabSpecialization vocabSpecialization;
        private Boolean allowUserDtmf;
        private Boolean allowDtmfInterruption;
        private UserDtmfOptions userDtmfOptions;
        private DenoisingMode denoisingMode;
        private PIIConfig piiConfig;
        private GuardrailConfig guardrailConfig;
        private VoiceHandbookConfig handbookConfig;
        private String timezone;

        private Builder() {
        }

        public Builder responseEngine(ResponseEngine responseEngine) {
            this.responseEngine = responseEngine;
            return this;
        }

        public Builder agentName(String agentName) {
            this.agentName = agentName;
            return this;
        }

        public Builder versionDescription(String versionDescription) {
            this.versionDescription = versionDescription;
            return this;
        }

        public Builder voiceId(String voiceId) {
            this.voiceId = voiceId;
            return this;
        }

        public Builder voiceModel(VoiceModel voiceModel) {
            this.voiceModel = voiceModel;
            return this;
        }

        public Builder fallbackVoiceIds(List<String> fallbackVoiceIds) {
            this.fallbackVoiceIds = fallbackVoiceIds;
            return this;
        }

        public Builder voiceTemperature(Double voiceTemperature) {
            this.voiceTemperature = voiceTemperature;
            return this;
        }

        public Builder voiceSpeed(Double voiceSpeed) {
            this.voiceSpeed = voiceSpeed;
            return this;
        }

        public Builder enableDynamicVoiceSpeed(Boolean enableDynamicVoiceSpeed) {
            this.enableDynamicVoiceSpeed = enableDynamicVoiceSpeed;
            return this;
        }

        public Builder enableDynamicResponsiveness(Boolean enableDynamicResponsiveness) {
            this.enableDynamicResponsiveness = enableDynamicResponsiveness;
            return this;
        }

        public Builder volume(Double volume) {
            this.volume = volume;
            return this;
        }

        public Builder voiceEmotion(VoiceEmotion voiceEmotion) {
            this.voiceEmotion = voiceEmotion;
            return this;
        }

        public Builder responsiveness(Double responsiveness) {
            this.responsiveness = responsiveness;
            return this;
        }

        public Builder interruptionSensitivity(Double interruptionSensitivity) {
            this.interruptionSensitivity = interruptionSensitivity;
            return this;
        }

        public Builder enableBackchannel(Boolean enableBackchannel) {
            this.enableBackchannel = enableBackchannel;
            return this;
        }

        public Builder backchannelFrequency(Double backchannelFrequency) {
            this.backchannelFrequency = backchannelFrequency;
            return this;
        }

        public Builder backchannelWords(List<String> backchannelWords) {
            this.backchannelWords = backchannelWords;
            return this;
        }

        public Builder reminderTriggerMs(Double reminderTriggerMs) {
            this.reminderTriggerMs = reminderTriggerMs;
            return this;
        }

        public Builder reminderMaxCount(Integer reminderMaxCount) {
            this.reminderMaxCount = reminderMaxCount;
            return this;
        }

        public Builder ambientSound(AmbientSound ambientSound) {
            this.ambientSound = ambientSound;
            return this;
        }

        public Builder ambientSoundVolume(Double ambientSoundVolume) {
            this.ambientSoundVolume = ambientSoundVolume;
            return this;
        }

        public Builder language(AgentLanguage language) {
            this.language = language;
            return this;
        }

        public Builder webhookUrl(String webhookUrl) {
            this.webhookUrl = webhookUrl;
            return this;
        }

        public Builder webhookEvents(List<WebhookEvent> webhookEvents) {
            this.webhookEvents = webhookEvents;
            return this;
        }

        public Builder webhookTimeoutMs(Integer webhookTimeoutMs) {
            this.webhookTimeoutMs = webhookTimeoutMs;
            return this;
        }

        public Builder boostedKeywords(List<String> boostedKeywords) {
            this.boostedKeywords = boostedKeywords;
            return this;
        }

        public Builder dataStorageSetting(DataStorageSetting dataStorageSetting) {
            this.dataStorageSetting = dataStorageSetting;
            return this;
        }

        public Builder dataStorageRetentionDays(Integer dataStorageRetentionDays) {
            this.dataStorageRetentionDays = dataStorageRetentionDays;
            return this;
        }

        public Builder optInSignedUrl(Boolean optInSignedUrl) {
            this.optInSignedUrl = optInSignedUrl;
            return this;
        }

        public Builder signedUrlExpirationMs(Integer signedUrlExpirationMs) {
            this.signedUrlExpirationMs = signedUrlExpirationMs;
            return this;
        }

        public Builder pronunciationDictionary(List<PronunciationEntry> pronunciationDictionary) {
            this.pronunciationDictionary = pronunciationDictionary;
            return this;
        }

        public Builder endCallAfterSilenceMs(Integer endCallAfterSilenceMs) {
            this.endCallAfterSilenceMs = endCallAfterSilenceMs;
            return this;
        }

        public Builder maxCallDurationMs(Integer maxCallDurationMs) {
            this.maxCallDurationMs = maxCallDurationMs;
            return this;
        }

        public Builder voicemailMessage(String voicemailMessage) {
            this.voicemailMessage = voicemailMessage;
            return this;
        }

        public Builder voicemailDetectionTimeoutMs(Integer voicemailDetectionTimeoutMs) {
            this.voicemailDetectionTimeoutMs = voicemailDetectionTimeoutMs;
            return this;
        }

        public Builder voicemailOption(VoicemailOption voicemailOption) {
            this.voicemailOption = voicemailOption;
            return this;
        }

        public Builder ivrOption(IvrOption ivrOption) {
            this.ivrOption = ivrOption;
            return this;
        }

        public Builder callScreeningOption(CallScreeningOption callScreeningOption) {
            this.callScreeningOption = callScreeningOption;
            return this;
        }

        public Builder postCallAnalysisData(List<PostCallAnalysisData> postCallAnalysisData) {
            this.postCallAnalysisData = postCallAnalysisData;
            return this;
        }

        public Builder postCallAnalysisModel(LlmModel postCallAnalysisModel) {
            this.postCallAnalysisModel = postCallAnalysisModel;
            return this;
        }

        public Builder analysisSuccessfulPrompt(String analysisSuccessfulPrompt) {
            this.analysisSuccessfulPrompt = analysisSuccessfulPrompt;
            return this;
        }

        public Builder analysisSummaryPrompt(String analysisSummaryPrompt) {
            this.analysisSummaryPrompt = analysisSummaryPrompt;
            return this;
        }

        public Builder analysisUserSentimentPrompt(String analysisUserSentimentPrompt) {
            this.analysisUserSentimentPrompt = analysisUserSentimentPrompt;
            return this;
        }

        public Builder beginMessageDelayMs(Integer beginMessageDelayMs) {
            this.beginMessageDelayMs = beginMessageDelayMs;
            return this;
        }

        public Builder ringDurationMs(Integer ringDurationMs) {
            this.ringDurationMs = ringDurationMs;
            return this;
        }

        public Builder sttMode(SttMode sttMode) {
            this.sttMode = sttMode;
            return this;
        }

        public Builder customSttConfig(CustomSttConfig customSttConfig) {
            this.customSttConfig = customSttConfig;
            return this;
        }

        public Builder vocabSpecialization(VocabSpecialization vocabSpecialization) {
            this.vocabSpecialization = vocabSpecialization;
            return this;
        }

        public Builder allowUserDtmf(Boolean allowUserDtmf) {
            this.allowUserDtmf = allowUserDtmf;
            return this;
        }

        public Builder allowDtmfInterruption(Boolean allowDtmfInterruption) {
            this.allowDtmfInterruption = allowDtmfInterruption;
            return this;
        }

        public Builder userDtmfOptions(UserDtmfOptions userDtmfOptions) {
            this.userDtmfOptions = userDtmfOptions;
            return this;
        }

        public Builder denoisingMode(DenoisingMode denoisingMode) {
            this.denoisingMode = denoisingMode;
            return this;
        }

        public Builder piiConfig(PIIConfig piiConfig) {
            this.piiConfig = piiConfig;
            return this;
        }

        public Builder guardrailConfig(GuardrailConfig guardrailConfig) {
            this.guardrailConfig = guardrailConfig;
            return this;
        }

        public Builder handbookConfig(VoiceHandbookConfig handbookConfig) {
            this.handbookConfig = handbookConfig;
            return this;
        }

        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public AgentRequest build() {
            return new AgentRequest(responseEngine, agentName, versionDescription, voiceId, voiceModel,
                    fallbackVoiceIds, voiceTemperature, voiceSpeed, enableDynamicVoiceSpeed,
                    enableDynamicResponsiveness, volume, voiceEmotion, responsiveness,
                    interruptionSensitivity, enableBackchannel, backchannelFrequency, backchannelWords,
                    reminderTriggerMs, reminderMaxCount, ambientSound, ambientSoundVolume, language,
                    webhookUrl, webhookEvents, webhookTimeoutMs, boostedKeywords, dataStorageSetting,
                    dataStorageRetentionDays, optInSignedUrl, signedUrlExpirationMs,
                    pronunciationDictionary, endCallAfterSilenceMs, maxCallDurationMs, voicemailMessage,
                    voicemailDetectionTimeoutMs, voicemailOption, ivrOption, callScreeningOption,
                    postCallAnalysisData, postCallAnalysisModel, analysisSuccessfulPrompt,
                    analysisSummaryPrompt, analysisUserSentimentPrompt, beginMessageDelayMs,
                    ringDurationMs, sttMode, customSttConfig, vocabSpecialization, allowUserDtmf,
                    allowDtmfInterruption, userDtmfOptions, denoisingMode, piiConfig, guardrailConfig,
                    handbookConfig, timezone);
        }
    }
}
