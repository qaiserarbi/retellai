package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * A call returned by the v3 call APIs. Either a {@link V3PhoneCallResponse} or a
 * {@link V3WebCallResponse}, distinguished by the {@code call_type} discriminator.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "call_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = V3PhoneCallResponse.class, name = "phone_call"),
        @JsonSubTypes.Type(value = V3WebCallResponse.class, name = "web_call")
})
public sealed interface V3CallResponse permits V3PhoneCallResponse, V3WebCallResponse {
}
