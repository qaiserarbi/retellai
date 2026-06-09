package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * A call returned by the v2 call APIs. Either a {@link V2PhoneCallResponse} or a
 * {@link V2WebCallResponse}, distinguished by the {@code call_type} discriminator.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "call_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = V2PhoneCallResponse.class, name = "phone_call"),
        @JsonSubTypes.Type(value = V2WebCallResponse.class, name = "web_call")
})
public sealed interface V2CallResponse permits V2PhoneCallResponse, V2WebCallResponse {
}
