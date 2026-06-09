package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * The content strategy used to compose an SMS message. Discriminated by the
 * wire {@code type} field.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SmsContentPredefined.class, name = "predefined"),
        @JsonSubTypes.Type(value = SmsContentInferred.class, name = "inferred"),
        @JsonSubTypes.Type(value = SmsContentTemplate.class, name = "template")
})
public sealed interface SmsContent
        permits SmsContentPredefined, SmsContentInferred, SmsContentTemplate {
}
