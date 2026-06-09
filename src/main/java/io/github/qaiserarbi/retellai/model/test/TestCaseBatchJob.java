package io.github.qaiserarbi.retellai.model.test;

import io.github.qaiserarbi.retellai.model.common.ResponseEngine;

/**
 * A batch test job that runs a set of test case definitions.
 *
 * @param testCaseBatchJobId    unique identifier for the test case batch job
 * @param status                status of the batch job
 * @param responseEngine        response engine used for the batch
 * @param passCount             number of test cases that passed
 * @param failCount             number of test cases that failed
 * @param errorCount            number of test cases that encountered errors
 * @param totalCount            total number of test cases in the batch
 * @param creationTimestamp     creation timestamp (milliseconds since epoch)
 * @param userModifiedTimestamp last modification timestamp (milliseconds since epoch)
 */
public record TestCaseBatchJob(
        String testCaseBatchJobId,
        Status status,
        ResponseEngine responseEngine,
        Integer passCount,
        Integer failCount,
        Integer errorCount,
        Integer totalCount,
        Long creationTimestamp,
        Long userModifiedTimestamp
) {

    /** Status of a batch test job. */
    public enum Status {
        IN_PROGRESS("in_progress"), COMPLETE("complete");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        @com.fasterxml.jackson.annotation.JsonValue
        public String value() {
            return value;
        }

        @com.fasterxml.jackson.annotation.JsonCreator
        public static Status from(String v) {
            for (var e : values()) {
                if (e.value.equals(v)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("Unknown Status: " + v);
        }
    }
}
