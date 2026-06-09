package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A 2D position used for frontend display of nodes, notes and begin tags on the flow canvas.
 *
 * @param x horizontal coordinate.
 * @param y vertical coordinate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record DisplayPosition(
        Double x,
        @JsonProperty("y") Double y
) {
}
