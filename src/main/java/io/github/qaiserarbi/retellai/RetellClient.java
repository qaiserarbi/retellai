package io.github.qaiserarbi.retellai;

import io.github.qaiserarbi.retellai.api.AgentApi;
import io.github.qaiserarbi.retellai.api.AgentVersionApi;
import io.github.qaiserarbi.retellai.api.BatchCallApi;
import io.github.qaiserarbi.retellai.api.BatchTestApi;
import io.github.qaiserarbi.retellai.api.CallApi;
import io.github.qaiserarbi.retellai.api.ChatAgentApi;
import io.github.qaiserarbi.retellai.api.ChatAgentVersionApi;
import io.github.qaiserarbi.retellai.api.ChatApi;
import io.github.qaiserarbi.retellai.api.ConcurrencyApi;
import io.github.qaiserarbi.retellai.api.ConversationFlowApi;
import io.github.qaiserarbi.retellai.api.ConversationFlowComponentApi;
import io.github.qaiserarbi.retellai.api.ExportApi;
import io.github.qaiserarbi.retellai.api.KnowledgeBaseApi;
import io.github.qaiserarbi.retellai.api.McpApi;
import io.github.qaiserarbi.retellai.api.PhoneNumberApi;
import io.github.qaiserarbi.retellai.api.PlaygroundApi;
import io.github.qaiserarbi.retellai.api.RetellLlmApi;
import io.github.qaiserarbi.retellai.api.SmsApi;
import io.github.qaiserarbi.retellai.api.TestCaseApi;
import io.github.qaiserarbi.retellai.api.TestRunApi;
import io.github.qaiserarbi.retellai.api.VoiceApi;
import io.github.qaiserarbi.retellai.internal.Json;
import io.github.qaiserarbi.retellai.internal.RetellClientOptions;
import io.github.qaiserarbi.retellai.internal.RetellProxyFactory;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.json.JsonMapper;

import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * The entry point to the Retell AI SDK.
 *
 * <p>Build one with {@link #builder()}, supplying at least an API key, then reach each resource
 * group through its accessor:
 *
 * {@snippet :
 * RetellClient client = RetellClient.builder()
 *         .apiKey(System.getenv("RETELL_API_KEY"))
 *         .build();
 *
 * AgentResponse agent = client.agents().getAgent("agent_123", null);
 * List<VoiceResponse> voices = client.voices().listVoices();
 * }
 *
 * <p>Instances are immutable and thread-safe; create one per API key and share it. Each resource
 * client is a declarative {@code @HttpExchange} proxy, created lazily on first access and cached.
 */
public final class RetellClient {

    /** The production base URL used unless overridden via {@link Builder#baseUrl(String)}. */
    public static final String DEFAULT_BASE_URL = "https://api.retellai.com";

    private final RetellProxyFactory proxyFactory;
    private final ConcurrentHashMap<Class<?>, Object> cache = new ConcurrentHashMap<>();

    private RetellClient(RetellClientOptions options) {
        this.proxyFactory = new RetellProxyFactory(options);
    }

    @SuppressWarnings("unchecked")
    private <T> T api(Class<T> apiType) {
        return (T) cache.computeIfAbsent(apiType, proxyFactory::createClient);
    }

    public AgentApi agents() {
        return api(AgentApi.class);
    }

    public AgentVersionApi agentVersions() {
        return api(AgentVersionApi.class);
    }

    public CallApi calls() {
        return api(CallApi.class);
    }

    public BatchCallApi batchCalls() {
        return api(BatchCallApi.class);
    }

    public PhoneNumberApi phoneNumbers() {
        return api(PhoneNumberApi.class);
    }

    public VoiceApi voices() {
        return api(VoiceApi.class);
    }

    public KnowledgeBaseApi knowledgeBases() {
        return api(KnowledgeBaseApi.class);
    }

    public RetellLlmApi retellLlms() {
        return api(RetellLlmApi.class);
    }

    public ConversationFlowApi conversationFlows() {
        return api(ConversationFlowApi.class);
    }

    public ConversationFlowComponentApi conversationFlowComponents() {
        return api(ConversationFlowComponentApi.class);
    }

    public ChatApi chats() {
        return api(ChatApi.class);
    }

    public ChatAgentApi chatAgents() {
        return api(ChatAgentApi.class);
    }

    public ChatAgentVersionApi chatAgentVersions() {
        return api(ChatAgentVersionApi.class);
    }

    public SmsApi sms() {
        return api(SmsApi.class);
    }

    public TestCaseApi testCases() {
        return api(TestCaseApi.class);
    }

    public BatchTestApi batchTests() {
        return api(BatchTestApi.class);
    }

    public TestRunApi testRuns() {
        return api(TestRunApi.class);
    }

    public PlaygroundApi playground() {
        return api(PlaygroundApi.class);
    }

    public ConcurrencyApi concurrency() {
        return api(ConcurrencyApi.class);
    }

    public McpApi mcpTools() {
        return api(McpApi.class);
    }

    public ExportApi exportRequests() {
        return api(ExportApi.class);
    }

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for {@link RetellClient}. Only {@link #apiKey(String)} is required. */
    public static final class Builder {

        private String apiKey;
        private String baseUrl = DEFAULT_BASE_URL;
        private Duration connectTimeout = Duration.ofSeconds(10);
        private Duration readTimeout = Duration.ofSeconds(120);
        private String userAgent = "retell-java/0.2.0";
        private RetryPolicy retryPolicy = RetryPolicy.defaults();
        private JsonMapper jsonMapper;
        private Consumer<RestClient.Builder> restClientCustomizer;

        private Builder() {
        }

        /** The Retell API key (found in the dashboard). Required. */
        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /** Override the API base URL. Defaults to {@link #DEFAULT_BASE_URL}. */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /** Connection-establishment timeout. Defaults to 10 seconds. */
        public Builder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        /** Per-request read timeout. Defaults to 120 seconds. */
        public Builder readTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        /** Override the {@code User-Agent} header sent with every request. */
        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        /**
         * Configure how transient failures are retried. Defaults to {@link RetryPolicy#defaults()};
         * pass {@link RetryPolicy#none()} to disable retries entirely.
         */
        public Builder retryPolicy(RetryPolicy retryPolicy) {
            this.retryPolicy = Objects.requireNonNull(retryPolicy, "retryPolicy");
            return this;
        }

        /** Convenience for {@code retryPolicy(currentPolicy.toBuilder().maxRetries(n).build())}. */
        public Builder maxRetries(int maxRetries) {
            this.retryPolicy = this.retryPolicy.toBuilder().maxRetries(maxRetries).build();
            return this;
        }

        /** Supply a custom Jackson {@link JsonMapper}. Defaults to {@link Json#defaultMapper()}. */
        public Builder jsonMapper(JsonMapper jsonMapper) {
            this.jsonMapper = jsonMapper;
            return this;
        }

        /**
         * Hook to customise the underlying {@link RestClient.Builder} (e.g. add interceptors,
         * proxies, extra default headers) just before it is built. Applied last.
         */
        public Builder customizeRestClient(Consumer<RestClient.Builder> restClientCustomizer) {
            this.restClientCustomizer = restClientCustomizer;
            return this;
        }

        public RetellClient build() {
            Objects.requireNonNull(apiKey, "apiKey must be set");
            JsonMapper mapper = jsonMapper != null ? jsonMapper : Json.defaultMapper();
            RetellClientOptions options = new RetellClientOptions(
                    apiKey, baseUrl, connectTimeout, readTimeout, userAgent, retryPolicy, mapper,
                    Optional.ofNullable(restClientCustomizer));
            return new RetellClient(options);
        }
    }
}
