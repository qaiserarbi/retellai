package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Example transcript used to finetune the transition condition to a global node.
 *
 * @param transcript the example transcript.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record GlobalNodeFinetuneTransitionExample(
        List<FinetuneExampleUtterance> transcript
) {
}
