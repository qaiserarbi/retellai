package io.github.qaiserarbi.retellai.internal;

import io.github.qaiserarbi.retellai.RetryPolicy;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.json.JsonMapper;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Immutable, fully-resolved configuration consumed by {@link RetellProxyFactory}. Built by
 * {@code RetellClient.Builder}; not part of the public surface that callers construct directly.
 */
public record RetellClientOptions(
        String apiKey,
        String baseUrl,
        Duration connectTimeout,
        Duration readTimeout,
        String userAgent,
        RetryPolicy retryPolicy,
        JsonMapper jsonMapper,
        Optional<Consumer<RestClient.Builder>> restClientCustomizer) {
}
