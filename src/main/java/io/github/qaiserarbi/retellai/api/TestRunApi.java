package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.Paginated;
import io.github.qaiserarbi.retellai.model.test.TestCaseJob;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/** HTTP interface for Retell test run (test case job) operations. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface TestRunApi {

    /** Get a test case job (test run) by ID. */
    @GetExchange("/get-test-run/{test_case_job_id}")
    TestCaseJob getTestRun(@PathVariable("test_case_job_id") String testCaseJobId);

    /**
     * List all test case jobs (test runs) for a batch test job (deprecated). Returns a bare array.
     *
     * @deprecated use {@link #listTestRunsV2} instead.
     */
    @Deprecated
    @GetExchange("/list-test-runs/{test_case_batch_job_id}")
    List<TestCaseJob> listTestRuns(
            @PathVariable("test_case_batch_job_id") String testCaseBatchJobId);

    /** List test case jobs (test runs) for a batch test job with pagination. */
    @GetExchange("/v2/list-test-runs/{test_case_batch_job_id}")
    Paginated<TestCaseJob> listTestRunsV2(
            @PathVariable("test_case_batch_job_id") String testCaseBatchJobId,
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "pagination_key", required = false) String paginationKey);
}
