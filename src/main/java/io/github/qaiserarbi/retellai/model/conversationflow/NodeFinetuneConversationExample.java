package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Example transcript used to finetune how the conversation should flow within a node.
 *
 * @param id         unique identifier for the example.
 * @param transcript the example transcript.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record NodeFinetuneConversationExample(
        String id,
        List<FinetuneExampleUtterance> transcript
) {
}
