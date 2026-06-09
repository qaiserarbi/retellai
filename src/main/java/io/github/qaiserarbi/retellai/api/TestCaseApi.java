package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.Paginated;
import io.github.qaiserarbi.retellai.model.test.ResponseEngineType;
import io.github.qaiserarbi.retellai.model.test.TestCaseDefinition;
import io.github.qaiserarbi.retellai.model.test.TestCaseDefinitionInput;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

/** HTTP interface for Retell test case definition operations. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface TestCaseApi {

    /** Create a new test case definition. */
    @PostExchange("/create-test-case-definition")
    TestCaseDefinition createTestCaseDefinition(@RequestBody TestCaseDefinitionInput request);

    /** Get a test case definition by ID. */
    @GetExchange("/get-test-case-definition/{test_case_definition_id}")
    TestCaseDefinition getTestCaseDefinition(
            @PathVariable("test_case_definition_id") String testCaseDefinitionId);

    /**
     * List test case definitions for a response engine (deprecated). Returns a bare array.
     *
     * @deprecated use {@link #listTestCaseDefinitionsV2} instead.
     */
    @Deprecated
    @GetExchange("/list-test-case-definitions")
    List<TestCaseDefinition> listTestCaseDefinitions(
            @RequestParam("type") ResponseEngineType type,
            @RequestParam(name = "llm_id", required = false) String llmId,
            @RequestParam(name = "conversation_flow_id", required = false) String conversationFlowId);

    /** List test case definitions with pagination. */
    @GetExchange("/v2/list-test-case-definitions")
    Paginated<TestCaseDefinition> listTestCaseDefinitionsV2(
            @RequestParam("type") ResponseEngineType type,
            @RequestParam(name = "llm_id", required = false) String llmId,
            @RequestParam(name = "conversation_flow_id", required = false) String conversationFlowId,
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "pagination_key", required = false) String paginationKey);

    /** Update a test case definition. */
    @PutExchange("/update-test-case-definition/{test_case_definition_id}")
    TestCaseDefinition updateTestCaseDefinition(
            @PathVariable("test_case_definition_id") String testCaseDefinitionId,
            @RequestBody TestCaseDefinitionInput request);

    /** Delete a test case definition. */
    @DeleteExchange("/delete-test-case-definition/{test_case_definition_id}")
    void deleteTestCaseDefinition(
            @PathVariable("test_case_definition_id") String testCaseDefinitionId);
}
