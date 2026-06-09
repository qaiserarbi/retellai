package io.github.qaiserarbi.retellai.model.misc;

/**
 * Current concurrency and concurrency limit information for the org.
 *
 * @param currentConcurrency        the current concurrency (amount of ongoing calls) of the org.
 * @param concurrencyLimit          the total concurrency limit of the org (base + purchased).
 * @param baseConcurrency           the free concurrency limit of the org.
 * @param purchasedConcurrency      the amount of concurrency the org has already purchased.
 * @param concurrencyPurchaseLimit  the maximum amount of concurrency the org can purchase.
 * @param remainingPurchaseLimit    the remaining amount of concurrency the org can purchase.
 * @param reservedInboundConcurrency number of normal concurrency slots reserved for inbound calls.
 * @param concurrencyBurstEnabled   whether burst concurrency mode is enabled.
 * @param concurrencyBurstLimit     the maximum concurrency limit when burst mode is enabled.
 */
public record ConcurrencyResponse(
        Integer currentConcurrency,
        Integer concurrencyLimit,
        Integer baseConcurrency,
        Integer purchasedConcurrency,
        Integer concurrencyPurchaseLimit,
        Integer remainingPurchaseLimit,
        Integer reservedInboundConcurrency,
        Boolean concurrencyBurstEnabled,
        Integer concurrencyBurstLimit
) {
}
