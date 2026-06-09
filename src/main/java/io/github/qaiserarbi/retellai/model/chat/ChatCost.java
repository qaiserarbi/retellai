package io.github.qaiserarbi.retellai.model.chat;

import io.github.qaiserarbi.retellai.model.call.ProductCost;
import java.util.List;

/**
 * Cost breakdown of a chat.
 *
 * @param productCosts list of products with their unit prices and costs in cents.
 * @param combinedCost combined cost of all individual costs in cents.
 */
public record ChatCost(
        List<ProductCost> productCosts,
        Double combinedCost) {
}
