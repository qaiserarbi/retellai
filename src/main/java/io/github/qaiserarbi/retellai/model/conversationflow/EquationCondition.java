package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Equation-based transition condition combining multiple {@link Equation}s with a logical
 * operator.
 *
 * @param equations the list of equations to evaluate (max 50).
 * @param operator  the logical operator joining the equations.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EquationCondition(
        List<Equation> equations,
        EquationOperator operator
) implements TransitionCondition {
}
