package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Rule for matching tool calls when applying a {@link ToolMock}.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ToolMockInputMatchRule.Any.class, name = "any"),
        @JsonSubTypes.Type(value = ToolMockInputMatchRule.PartialMatch.class, name = "partial_match")
})
public sealed interface ToolMockInputMatchRule
        permits ToolMockInputMatchRule.Any, ToolMockInputMatchRule.PartialMatch {

    /** Match any input of the tool. */
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    record Any() implements ToolMockInputMatchRule {
    }

    /**
     * Match only calls with specific arguments.
     *
     * @param args arguments to match; only provided fields will be checked
     */
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    record PartialMatch(java.util.Map<String, Object> args) implements ToolMockInputMatchRule {
    }
}
