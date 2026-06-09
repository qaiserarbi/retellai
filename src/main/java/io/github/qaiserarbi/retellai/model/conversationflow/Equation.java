package io.github.qaiserarbi.retellai.model.conversationflow;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A single equation within an {@link EquationCondition}.
 *
 * @param left     left side of the equation.
 * @param operator comparison operator.
 * @param right    right side of the equation (not required for {@code exists}/{@code not_exist}).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Equation(
        String left,
        EquationComparisonOperator operator,
        String right
) {
}
