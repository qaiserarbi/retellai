package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** PII category to scrub from transcripts and recordings. */
public enum PiiCategory {
    PERSON_NAME("person_name"),
    ADDRESS("address"),
    EMAIL("email"),
    PHONE_NUMBER("phone_number"),
    SSN("ssn"),
    PASSPORT("passport"),
    DRIVER_LICENSE("driver_license"),
    CREDIT_CARD("credit_card"),
    BANK_ACCOUNT("bank_account"),
    PASSWORD("password"),
    PIN("pin"),
    MEDICAL_ID("medical_id"),
    DATE_OF_BIRTH("date_of_birth"),
    CUSTOMER_ACCOUNT_NUMBER("customer_account_number");

    private final String value;

    PiiCategory(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PiiCategory from(String v) {
        for (var e : values()) if (e.value.equals(v)) return e;
        throw new IllegalArgumentException("Unknown PiiCategory: " + v);
    }
}
