package io.github.qaiserarbi.retellai.model.call;

import java.util.List;

/**
 * LLM token usage of the call, available after call ends. Not populated if using
 * custom LLM, realtime API, or no LLM call is made.
 */
public record LlmTokenUsage(
        List<Double> values,
        Double average,
        Double numRequests) {
}
