package io.github.qaiserarbi.retellai.model.call;

/** A product with its unit price and cost in cents associated with a call. */
public record ProductCost(
        String product,
        Double unitPrice,
        Double cost,
        Boolean isTransferLegCost) {
}
