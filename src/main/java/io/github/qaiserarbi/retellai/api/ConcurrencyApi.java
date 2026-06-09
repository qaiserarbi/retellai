package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.misc.ConcurrencyResponse;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * Operations for retrieving org concurrency information.
 */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface ConcurrencyApi {

    /**
     * Get the current concurrency and concurrency limit of the org.
     *
     * @return the concurrency information.
     */
    @GetExchange("/get-concurrency")
    ConcurrencyResponse getConcurrency();
}
