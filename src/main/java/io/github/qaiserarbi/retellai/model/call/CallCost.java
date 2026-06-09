package io.github.qaiserarbi.retellai.model.call;

import java.util.List;

/** Cost of the call, including all the products and their costs and discount. */
public record CallCost(
        List<ProductCost> productCosts,
        Double totalDurationSeconds,
        Double totalDurationUnitPrice,
        Double combinedCost) {
}
