package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Example transcript used to finetune how a node should transition.
 *
 * @param id                unique identifier for the example.
 * @param transcript        the example transcript.
 * @param destinationNodeId optional destination node id.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record NodeFinetuneTransitionExample(
        String id,
        List<FinetuneExampleUtterance> transcript,
        String destinationNodeId
) {
}
