package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Request body to create a batch test job.
 *
 * @param testCaseDefinitionIds array of test case definition IDs to run (1-1000)
 * @param responseEngine        response engine to use for the test cases (Custom LLM not supported)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateBatchTestRequest(
        List<String> testCaseDefinitionIds,
        RetellResponseEngine responseEngine
) {

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link CreateBatchTestRequest}. */
    public static final class Builder {
        private List<String> testCaseDefinitionIds;
        private RetellResponseEngine responseEngine;

        private Builder() {
        }

        public Builder testCaseDefinitionIds(List<String> testCaseDefinitionIds) {
            this.testCaseDefinitionIds = testCaseDefinitionIds;
            return this;
        }

        public Builder responseEngine(RetellResponseEngine responseEngine) {
            this.responseEngine = responseEngine;
            return this;
        }

        public CreateBatchTestRequest build() {
            return new CreateBatchTestRequest(testCaseDefinitionIds, responseEngine);
        }
    }
}
