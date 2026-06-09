package io.github.qaiserarbi.retellai.model.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * A user-submitted survey form request.
 *
 * @param form          a map of survey form data with string values
 * @param utmParameters UTM tracking parameters
 * @param referrer      referrer URL
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserFormRequest(
        Map<String, String> form,
        Map<String, String> utmParameters,
        String referrer
) {
}
