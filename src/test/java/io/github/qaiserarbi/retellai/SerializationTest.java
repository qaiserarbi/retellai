package io.github.qaiserarbi.retellai;

import io.github.qaiserarbi.retellai.internal.Json;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;
import io.github.qaiserarbi.retellai.model.common.AnalysisData;
import io.github.qaiserarbi.retellai.model.common.PostCallAnalysisData;
import io.github.qaiserarbi.retellai.model.common.ResponseEngine;
import io.github.qaiserarbi.retellai.model.common.ResponseEngineRetellLm;
import io.github.qaiserarbi.retellai.model.common.StringAnalysisData;
import io.github.qaiserarbi.retellai.model.call.CallStatus;
import io.github.qaiserarbi.retellai.model.call.V2CallResponse;
import io.github.qaiserarbi.retellai.model.call.V2PhoneCallResponse;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Validates that the generated records, enums and sealed unions (de)serialize correctly with the
 * SDK's configured Jackson mapper: snake_case naming, discriminator wire values, and round-trips.
 */
class SerializationTest {

    private final JsonMapper mapper = Json.defaultMapper();

    @Test
    void responseEngineUnion_serializesDiscriminatorAndRoundTrips() {
        ResponseEngine engine = new ResponseEngineRetellLm("llm_abc", 0.0);

        String json = mapper.writerFor(ResponseEngine.class).writeValueAsString(engine);
        assertTrue(json.contains("\"type\":\"retell-llm\""), json);
        assertTrue(json.contains("\"llm_id\":\"llm_abc\""), json); // snake_case mapping

        ResponseEngine back = mapper.readValue(json, ResponseEngine.class);
        assertInstanceOf(ResponseEngineRetellLm.class, back);
        assertEquals(engine, back);
    }

    @Test
    void agentVersionReference_numericAndStringScalarUnion() {
        AgentVersionReference numeric = AgentVersionReference.of(3);
        assertEquals("3", mapper.writeValueAsString(numeric));

        AgentVersionReference tag = AgentVersionReference.of("prod");
        assertEquals("\"prod\"", mapper.writeValueAsString(tag));

        // Round-trip both wire forms back through the scalar-union creator.
        assertEquals(3, ((Number) mapper.readValue("3", AgentVersionReference.class).value()).intValue());
        assertEquals("prod", mapper.readValue("\"prod\"", AgentVersionReference.class).value());
    }

    @Test
    void callResponseUnion_usesCallTypeDiscriminator() {
        V2CallResponse call = new V2PhoneCallResponse(
                "+14150000000", "+14151111111", null, null,
                "call_123", "agent_1", null, 0, CallStatus.ENDED,
                null, null, null, null, null, null,
                1700000000000L, 1700000005000L, null, 5000L,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null);

        String json = mapper.writerFor(V2CallResponse.class).writeValueAsString(call);
        assertTrue(json.contains("\"call_type\":\"phone_call\""), json);
        assertTrue(json.contains("\"from_number\":\"+14150000000\""), json);
        assertTrue(json.contains("\"call_status\":\"ended\""), json); // enum @JsonValue

        V2CallResponse back = mapper.readValue(json, V2CallResponse.class);
        assertInstanceOf(V2PhoneCallResponse.class, back);
        assertEquals(call, back);
    }

    @Test
    void analysisData_sharedVariantAcrossUnions() {
        StringAnalysisData data = new StringAnalysisData(
                "order_id", "The customer order id", List.of("ABC-1"), true, null);

        // As AnalysisData
        String asAnalysis = mapper.writerFor(AnalysisData.class).writeValueAsString(data);
        assertTrue(asAnalysis.contains("\"type\":\"string\""), asAnalysis);
        assertInstanceOf(StringAnalysisData.class, mapper.readValue(asAnalysis, AnalysisData.class));

        // The same record also participates in the PostCallAnalysisData union
        String asPostCall = mapper.writerFor(PostCallAnalysisData.class).writeValueAsString(data);
        assertTrue(asPostCall.contains("\"type\":\"string\""), asPostCall);
        assertInstanceOf(StringAnalysisData.class, mapper.readValue(asPostCall, PostCallAnalysisData.class));
    }

    @Test
    void unknownProperties_areIgnored() {
        // Forward-compat: a field the SDK doesn't model must not break deserialization.
        String json = "{\"type\":\"retell-llm\",\"llm_id\":\"llm_x\",\"version\":1,\"brand_new_field\":42}";
        ResponseEngine back = mapper.readValue(json, ResponseEngine.class);
        assertInstanceOf(ResponseEngineRetellLm.class, back);
        assertEquals("llm_x", ((ResponseEngineRetellLm) back).llmId());
    }
}
