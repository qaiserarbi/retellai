package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.qaiserarbi.retellai.model.common.ResponseEngine;
import io.github.qaiserarbi.retellai.model.common.ResponseEngineConversationFlow;
import io.github.qaiserarbi.retellai.model.common.ResponseEngineRetellLm;

/**
 * Response engine for test cases. Custom LLM is not supported, so only the
 * retell-llm and conversation-flow variants are valid here.
 *
 * <p>Wraps the shared {@link ResponseEngine} discriminated union. Jackson reads
 * and writes the inner value (including its {@code type} discriminator) directly.
 */
public record RetellResponseEngine(@JsonValue ResponseEngine value) {

    @JsonCreator
    public RetellResponseEngine {
    }

    /** Wrap a Retell LLM response engine variant. */
    public static RetellResponseEngine of(ResponseEngineRetellLm retellLm) {
        return new RetellResponseEngine(retellLm);
    }

    /** Wrap a conversation flow response engine variant. */
    public static RetellResponseEngine of(ResponseEngineConversationFlow conversationFlow) {
        return new RetellResponseEngine(conversationFlow);
    }
}
