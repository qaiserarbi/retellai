package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Behavior presets for voice agents. Each preset toggles a response-style behavior.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record VoiceHandbookConfig(
        Boolean defaultPersonality,
        Boolean naturalFillerWords,
        Boolean highEmpathy,
        Boolean echoVerification,
        Boolean natoPhoneticAlphabet,
        Boolean speechNormalization,
        Boolean smartMatching,
        Boolean aiDisclosure,
        Boolean scopeBoundaries
) {
}
