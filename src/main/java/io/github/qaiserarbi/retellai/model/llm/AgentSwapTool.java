package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.qaiserarbi.retellai.model.common.AgentVersionReference;

/**
 * A tool that swaps the active agent during a call.
 *
 * @param name                        unique name of the tool.
 * @param description                 describes what the tool does and when to call it.
 * @param agentId                     the id of the agent to swap to.
 * @param agentVersion                the version of the agent to swap to.
 * @param speakDuringExecution        if true, will speak during execution.
 * @param executionMessageDescription the message to speak when executing the agent swap.
 * @param executionMessageType        type of execution message (prompt or static_text).
 * @param postCallAnalysisSetting     post call analysis setting for the agent swap.
 * @param webhookSetting              webhook setting for the agent swap.
 * @param keepCurrentVoice            if true, keep the current voice when swapping agents.
 * @param keepCurrentLanguage         if true, keep the current language when swapping agents.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentSwapTool(
        String name,
        String description,
        String agentId,
        AgentVersionReference agentVersion,
        Boolean speakDuringExecution,
        String executionMessageDescription,
        ExecutionMessageType executionMessageType,
        PostCallAnalysisSetting postCallAnalysisSetting,
        AgentSwapWebhookSetting webhookSetting,
        Boolean keepCurrentVoice,
        Boolean keepCurrentLanguage
) implements Tool {
}
