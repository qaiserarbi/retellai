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

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link UserFormRequest}. */
    public static final class Builder {
        private Map<String, String> form;
        private Map<String, String> utmParameters;
        private String referrer;

        private Builder() {
        }

        public Builder form(Map<String, String> form) {
            this.form = form;
            return this;
        }

        public Builder utmParameters(Map<String, String> utmParameters) {
            this.utmParameters = utmParameters;
            return this;
        }

        public Builder referrer(String referrer) {
            this.referrer = referrer;
            return this;
        }

        public UserFormRequest build() {
            return new UserFormRequest(form, utmParameters, referrer);
        }
    }
}
