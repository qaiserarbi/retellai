package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Voice model used for the selected voice. */
public enum VoiceModel {
    ELEVEN_TURBO_V2("eleven_turbo_v2"),
    ELEVEN_FLASH_V2("eleven_flash_v2"),
    ELEVEN_TURBO_V2_5("eleven_turbo_v2_5"),
    ELEVEN_FLASH_V2_5("eleven_flash_v2_5"),
    ELEVEN_MULTILINGUAL_V2("eleven_multilingual_v2"),
    ELEVEN_V3("eleven_v3"),
    SONIC_3("sonic-3"),
    SONIC_3_LATEST("sonic-3-latest"),
    SONIC_3_5("sonic-3.5"),
    TTS_1("tts-1"),
    GPT_4O_MINI_TTS("gpt-4o-mini-tts"),
    SPEECH_02_TURBO("speech-02-turbo"),
    SPEECH_2_8_TURBO("speech-2.8-turbo"),
    S1("s1"),
    S2_PRO("s2-pro"),
    S2_1_PRO("s2.1-pro");

    private final String value;

    VoiceModel(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static VoiceModel from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown VoiceModel: " + v);
    }
}
