package io.github.qaiserarbi.retellai.internal;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.converter.json.JacksonJsonHttpMessageConverter;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.net.http.HttpClient;
import java.util.concurrent.Executors;

/**
 * Assembles the synchronous transport stack and produces declarative HTTP interface clients.
 *
 * <p>The chain is: a JDK {@link HttpClient} (running requests on a virtual-thread-per-task executor,
 * Java&nbsp;25) &rarr; Spring's {@link JdkClientHttpRequestFactory} &rarr; a {@link RestClient}
 * configured with the bearer token, a Jackson&nbsp;3 message converter and the typed error handler
 * &rarr; a {@link RestClientAdapter} &rarr; an {@link HttpServiceProxyFactory} that backs every
 * {@code @HttpExchange} resource interface.
 */
public final class RetellProxyFactory {

    private final HttpServiceProxyFactory factory;

    public RetellProxyFactory(RetellClientOptions options) {
        HttpClient httpClient = HttpClient.newBuilder()
                .executor(Executors.newVirtualThreadPerTaskExecutor())
                .connectTimeout(options.connectTimeout())
                .build();

        JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory(httpClient);
        requestFactory.setReadTimeout(options.readTimeout());

        JacksonJsonHttpMessageConverter jsonConverter =
                new JacksonJsonHttpMessageConverter(options.jsonMapper());

        RestClient.Builder builder = RestClient.builder()
                .baseUrl(options.baseUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + options.apiKey())
                .defaultHeader(HttpHeaders.USER_AGENT, options.userAgent())
                .requestFactory(requestFactory)
                .configureMessageConverters(converters -> converters
                        .registerDefaults()
                        .withJsonConverter(jsonConverter))
                .requestInterceptor(new RetryInterceptor(options.retryPolicy()));

        new RetellErrorHandler(options.jsonMapper()).apply(builder);
        options.restClientCustomizer().ifPresent(customizer -> customizer.accept(builder));

        RestClient restClient = builder.build();
        this.factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
    }

    /** Creates a proxy implementing the given {@code @HttpExchange} resource interface. */
    public <T> T createClient(Class<T> apiType) {
        return factory.createClient(apiType);
    }
}
