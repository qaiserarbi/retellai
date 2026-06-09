package io.github.qaiserarbi.retellai.internal;

import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.json.JsonMapper;

/**
 * Central Jackson 3 configuration for the SDK.
 *
 * <p>The mapper maps Java camelCase record components to the API's {@code snake_case} wire format
 * and ignores unknown response properties so newly-added Retell fields never break deserialization.
 * Jackson 3 already maps {@code java.time} and {@code Optional} types out of the box, so no extra
 * modules are registered here.
 *
 * <p>This is the single place that touches the relocated {@code tools.jackson} packages; everything
 * else in the SDK uses the package-stable {@code com.fasterxml.jackson.annotation} annotations.
 */
public final class Json {

    private Json() {
    }

    /** A new, fully-configured {@link JsonMapper}. Jackson 3 mappers are immutable and thread-safe. */
    public static JsonMapper defaultMapper() {
        return JsonMapper.builder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .build();
    }
}
