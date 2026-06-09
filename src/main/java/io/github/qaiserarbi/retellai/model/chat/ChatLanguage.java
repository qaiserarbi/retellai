package io.github.qaiserarbi.retellai.model.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Concrete locale codes supported by chat agents. */
public enum ChatLanguage {
    EN_US("en-US"),
    EN_IN("en-IN"),
    EN_GB("en-GB"),
    EN_AU("en-AU"),
    EN_NZ("en-NZ"),
    DE_DE("de-DE"),
    ES_ES("es-ES"),
    ES_419("es-419"),
    HI_IN("hi-IN"),
    FR_FR("fr-FR"),
    FR_CA("fr-CA"),
    JA_JP("ja-JP"),
    PT_PT("pt-PT"),
    PT_BR("pt-BR"),
    ZH_CN("zh-CN"),
    MULTI("multi");

    private final String value;

    ChatLanguage(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatLanguage from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatLanguage: " + v);
    }
}
