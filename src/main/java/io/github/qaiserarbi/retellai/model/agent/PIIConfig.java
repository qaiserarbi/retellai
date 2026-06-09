package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Configuration for PII scrubbing from transcripts and recordings.
 *
 * @param mode       the processing mode for PII scrubbing
 * @param categories list of PII categories to scrub
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PIIConfig(
        PiiMode mode,
        List<PiiCategory> categories
) {
}
