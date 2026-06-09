package io.github.qaiserarbi.retellai.model.misc;

/**
 * An export request record.
 *
 * @param exportRequestId  unique id of the export request.
 * @param channel          the channel of the export (call or chat).
 * @param status           the current status of the export request.
 * @param url              the URL to download the exported data, when available.
 * @param createdTimestamp the creation time of the export request, in milliseconds since epoch.
 * @param timezone         the timezone used for the export.
 */
public record ExportRequest(
        String exportRequestId,
        ExportChannel channel,
        ExportStatus status,
        String url,
        Long createdTimestamp,
        String timezone
) {
}
