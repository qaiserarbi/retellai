package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Content of an SMS sent by an SMS tool: predefined, inferred, or template-based. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SmsContentPredefined.class, name = "predefined"),
        @JsonSubTypes.Type(value = SmsContentInferred.class, name = "inferred"),
        @JsonSubTypes.Type(value = SmsContentTemplate.class, name = "template")
})
public sealed interface SmsContent
        permits SmsContentPredefined, SmsContentInferred, SmsContentTemplate {
}
