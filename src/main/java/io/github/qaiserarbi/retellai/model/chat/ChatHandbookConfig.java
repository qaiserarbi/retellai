package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Behavior presets for chat agents. Voice-only presets are excluded.
 *
 * @param defaultPersonality professional call center rep baseline.
 * @param highEmpathy        warm acknowledgment of caller concerns.
 * @param aiDisclosure       when asked, acknowledge being a virtual assistant.
 * @param scopeBoundaries    stay within prompt/context scope, don't invent details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChatHandbookConfig(
        Boolean defaultPersonality,
        Boolean highEmpathy,
        Boolean aiDisclosure,
        Boolean scopeBoundaries) {
}
