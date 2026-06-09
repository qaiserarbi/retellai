package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.Paginated;
import io.github.qaiserarbi.retellai.model.test.CreateBatchTestRequest;
import io.github.qaiserarbi.retellai.model.test.ResponseEngineType;
import io.github.qaiserarbi.retellai.model.test.TestCaseBatchJob;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/** HTTP interface for Retell batch test operations. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface BatchTestApi {

    /** Create a new batch test job. */
    @PostExchange("/create-batch-test")
    TestCaseBatchJob createBatchTest(@RequestBody CreateBatchTestRequest request);

    /** Get a batch test job by ID. */
    @GetExchange("/get-batch-test/{test_case_batch_job_id}")
    TestCaseBatchJob getBatchTest(@PathVariable("test_case_batch_job_id") String testCaseBatchJobId);

    /**
     * List batch test jobs for a response engine (deprecated). Returns a bare array.
     *
     * @deprecated use {@link #listBatchTestsV2} instead.
     */
    @Deprecated
    @GetExchange("/list-batch-tests")
    List<TestCaseBatchJob> listBatchTests(
            @RequestParam("type") ResponseEngineType type,
            @RequestParam(name = "llm_id", required = false) String llmId,
            @RequestParam(name = "conversation_flow_id", required = false) String conversationFlowId,
            @RequestParam(name = "version", required = false) Integer version);

    /** List batch test jobs with pagination. */
    @GetExchange("/v2/list-batch-tests")
    Paginated<TestCaseBatchJob> listBatchTestsV2(
            @RequestParam("type") ResponseEngineType type,
            @RequestParam(name = "llm_id", required = false) String llmId,
            @RequestParam(name = "conversation_flow_id", required = false) String conversationFlowId,
            @RequestParam(name = "version", required = false) Integer version,
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "pagination_key", required = false) String paginationKey);
}
