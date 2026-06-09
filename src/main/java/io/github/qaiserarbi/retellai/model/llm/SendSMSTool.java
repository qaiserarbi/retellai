package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A tool that sends an SMS message.
 *
 * @param name                        unique name of the tool.
 * @param description                 describes what the tool does and when to call it.
 * @param speakDuringExecution        if true, the agent speaks a short line before sending the SMS.
 * @param executionMessageDescription what to say before sending the SMS.
 * @param executionMessageType        type of execution message (prompt or static_text).
 * @param smsContent                  the content of the SMS to send.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SendSMSTool(
        String name,
        String description,
        Boolean speakDuringExecution,
        String executionMessageDescription,
        ExecutionMessageType executionMessageType,
        SmsContent smsContent
) implements Tool {
}
