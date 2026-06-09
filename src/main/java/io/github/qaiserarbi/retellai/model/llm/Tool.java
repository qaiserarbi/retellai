package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * A tool the model may call. Discriminated on the {@code type} field. Predefined tools (end call,
 * transfer call, etc.) and custom tools are all variants of this sealed union.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EndCallTool.class, name = "end_call"),
        @JsonSubTypes.Type(value = TransferCallTool.class, name = "transfer_call"),
        @JsonSubTypes.Type(value = CheckAvailabilityCalTool.class, name = "check_availability_cal"),
        @JsonSubTypes.Type(value = BookAppointmentCalTool.class, name = "book_appointment_cal"),
        @JsonSubTypes.Type(value = AgentSwapTool.class, name = "agent_swap"),
        @JsonSubTypes.Type(value = PressDigitTool.class, name = "press_digit"),
        @JsonSubTypes.Type(value = SendSMSTool.class, name = "send_sms"),
        @JsonSubTypes.Type(value = CustomTool.class, name = "custom"),
        @JsonSubTypes.Type(value = CodeTool.class, name = "code"),
        @JsonSubTypes.Type(value = ExtractDynamicVariableTool.class, name = "extract_dynamic_variable"),
        @JsonSubTypes.Type(value = BridgeTransferTool.class, name = "bridge_transfer"),
        @JsonSubTypes.Type(value = CancelTransferTool.class, name = "cancel_transfer"),
        @JsonSubTypes.Type(value = MCPTool.class, name = "mcp")
})
public sealed interface Tool
        permits EndCallTool, TransferCallTool, CheckAvailabilityCalTool, BookAppointmentCalTool,
        AgentSwapTool, PressDigitTool, SendSMSTool, CustomTool, CodeTool,
        ExtractDynamicVariableTool, BridgeTransferTool, CancelTransferTool, MCPTool {
}
