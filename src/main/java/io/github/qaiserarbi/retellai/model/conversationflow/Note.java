package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A visual annotation displayed on the flow canvas.
 *
 * @param id              unique identifier for the note.
 * @param content         text content; may contain image refs in the form {@code <image:asset_id>}.
 * @param displayPosition position of the note on the canvas.
 * @param size            dimensions of the note on the canvas.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Note(
        String id,
        String content,
        DisplayPosition displayPosition,
        NoteSize size
) {
    /**
     * Dimensions of a {@link Note} on the canvas.
     *
     * @param width  width in canvas units.
     * @param height height in canvas units.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record NoteSize(
            Double width,
            Double height
    ) {
    }
}
