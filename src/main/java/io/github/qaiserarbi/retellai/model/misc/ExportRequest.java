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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link ExportRequest}. */
    public static final class Builder {
        private String exportRequestId;
        private ExportChannel channel;
        private ExportStatus status;
        private String url;
        private Long createdTimestamp;
        private String timezone;

        private Builder() {
        }

        public Builder exportRequestId(String exportRequestId) {
            this.exportRequestId = exportRequestId;
            return this;
        }

        public Builder channel(ExportChannel channel) {
            this.channel = channel;
            return this;
        }

        public Builder status(ExportStatus status) {
            this.status = status;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder createdTimestamp(Long createdTimestamp) {
            this.createdTimestamp = createdTimestamp;
            return this;
        }

        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public ExportRequest build() {
            return new ExportRequest(exportRequestId, channel, status, url, createdTimestamp, timezone);
        }
    }
}
