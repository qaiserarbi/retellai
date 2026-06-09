package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A tool that checks availability for a Cal.com event.
 *
 * @param name        unique name of the tool.
 * @param description describes what the tool does and when to call it.
 * @param calApiKey   Cal.com API key with access to the event.
 * @param eventTypeId Cal.com event type id (number or dynamic variable).
 * @param timezone    IANA timezone to use when checking availability.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CheckAvailabilityCalTool(
        String name,
        String description,
        String calApiKey,
        EventTypeId eventTypeId,
        String timezone
) implements Tool {
}
