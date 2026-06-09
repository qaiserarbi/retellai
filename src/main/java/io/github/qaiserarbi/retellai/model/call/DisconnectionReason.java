package io.github.qaiserarbi.retellai.model.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** The reason for the disconnection of a call. */
public enum DisconnectionReason {
    USER_HANGUP("user_hangup"),
    AGENT_HANGUP("agent_hangup"),
    CALL_TRANSFER("call_transfer"),
    VOICEMAIL_REACHED("voicemail_reached"),
    IVR_REACHED("ivr_reached"),
    INACTIVITY("inactivity"),
    MAX_DURATION_REACHED("max_duration_reached"),
    CONCURRENCY_LIMIT_REACHED("concurrency_limit_reached"),
    NO_CONCURRENCY_FALLBACK("no_concurrency_fallback"),
    NO_VALID_PAYMENT("no_valid_payment"),
    SCAM_DETECTED("scam_detected"),
    DIAL_BUSY("dial_busy"),
    DIAL_FAILED("dial_failed"),
    DIAL_NO_ANSWER("dial_no_answer"),
    INVALID_DESTINATION("invalid_destination"),
    TELEPHONY_PROVIDER_PERMISSION_DENIED("telephony_provider_permission_denied"),
    TELEPHONY_PROVIDER_UNAVAILABLE("telephony_provider_unavailable"),
    SIP_ROUTING_ERROR("sip_routing_error"),
    MARKED_AS_SPAM("marked_as_spam"),
    USER_DECLINED("user_declined"),
    ERROR_LLM_WEBSOCKET_OPEN("error_llm_websocket_open"),
    ERROR_LLM_WEBSOCKET_LOST_CONNECTION("error_llm_websocket_lost_connection"),
    ERROR_LLM_WEBSOCKET_RUNTIME("error_llm_websocket_runtime"),
    ERROR_LLM_WEBSOCKET_CORRUPT_PAYLOAD("error_llm_websocket_corrupt_payload"),
    ERROR_NO_AUDIO_RECEIVED("error_no_audio_received"),
    ERROR_ASR("error_asr"),
    ERROR_RETELL("error_retell"),
    ERROR_UNKNOWN("error_unknown"),
    ERROR_USER_NOT_JOINED("error_user_not_joined"),
    REGISTERED_CALL_TIMEOUT("registered_call_timeout"),
    TRANSFER_BRIDGED("transfer_bridged"),
    TRANSFER_CANCELLED("transfer_cancelled"),
    MANUAL_STOPPED("manual_stopped"),
    CALL_TAKE_OVER("call_take_over");

    private final String value;

    DisconnectionReason(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static DisconnectionReason from(String v) {
        for (var e : values()) {
            if (e.value.equals(v)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown DisconnectionReason: " + v);
    }
}
