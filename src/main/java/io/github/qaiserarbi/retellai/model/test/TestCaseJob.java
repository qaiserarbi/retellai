package io.github.qaiserarbi.retellai.model.test;

import java.util.Map;

/**
 * A test case job (test run) — a single execution of a test case definition.
 *
 * @param testCaseJobId              unique identifier for the test case job
 * @param status                    status of the test case job
 * @param testCaseDefinitionId      ID of the test case definition used
 * @param testCaseDefinitionSnapshot snapshot of the test case definition at execution time
 * @param transcriptSnapshot        snapshot of the transcript generated during execution
 * @param resultExplanation         explanation of the test result
 * @param creationTimestamp         creation timestamp (milliseconds since epoch)
 * @param userModifiedTimestamp     last modification timestamp (milliseconds since epoch)
 */
public record TestCaseJob(
        String testCaseJobId,
        Status status,
        String testCaseDefinitionId,
        TestCaseDefinition testCaseDefinitionSnapshot,
        Map<String, Object> transcriptSnapshot,
        String resultExplanation,
        Long creationTimestamp,
        Long userModifiedTimestamp
) {

    /** Status of a test case job. */
    public enum Status {
        IN_PROGRESS("in_progress"), PASS("pass"), FAIL("fail"), ERROR("error");

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
