# Retell AI — Java SDK

An unofficial, production-grade Java SDK for the [Retell AI](https://www.retellai.com/) REST API.
Retell does not ship an official Java SDK; this library fills that gap with full endpoint
coverage, type-safe models, and a modern, framework-light design.

- **Java 25** — `record` DTOs, `sealed` interfaces for the API's polymorphic types,
  pattern-matchable unions, and a virtual-thread-backed HTTP client.
- **Spring Framework 7 declarative HTTP clients** — every endpoint is an `@HttpExchange`
  interface backed by the synchronous `RestClient`; blocking methods that return values directly.
- **Jackson 3** for JSON (snake_case mapping, forward-compatible with unknown fields).
- **Typed exceptions** — non-2xx responses map to a precise exception hierarchy.
- **No Spring Boot required** — a plain `RetellClient.builder()` wires everything itself; works
  in any application, Spring or not.

> Status: covers all ~70 documented REST endpoints across ~21 resource groups. Generated from
> Retell's published OpenAPI spec.

## Requirements

- JDK 25+
- Pulls in `spring-web`, `spring-context`, and Jackson 3 (managed via the Spring Boot 4.0.x BOM).

## Installation

Build and publish to your local Maven repository:

```bash
./gradlew publishToMavenLocal
```

Then depend on it:

```groovy
// build.gradle
implementation 'io.github.qaiserarbi:retellai:0.1.0'
```

## Quick start

```java
import io.github.qaiserarbi.retellai.RetellClient;
import io.github.qaiserarbi.retellai.model.agent.AgentResponse;
import io.github.qaiserarbi.retellai.model.voice.VoiceResponse;
import java.util.List;

RetellClient client = RetellClient.builder()
        .apiKey(System.getenv("RETELL_API_KEY"))
        .build();

// List the voices available to your account
List<VoiceResponse> voices = client.voices().listVoices();

// Fetch an agent (second arg is an optional version; null = latest)
AgentResponse agent = client.agents().getAgent("agent_oBeDLoLOeuAbiuaMFXRtDOLriTJ5tSxD", null);
```

### Placing an outbound phone call

Request bodies are `record`s whose optional fields are nullable — pass `null` for anything you
don't need:

```java
import io.github.qaiserarbi.retellai.model.call.CreatePhoneCallRequest;
import io.github.qaiserarbi.retellai.model.call.V2PhoneCallResponse;

V2PhoneCallResponse call = client.calls().createPhoneCall(
        new CreatePhoneCallRequest(
                "+14157774444",   // fromNumber
                "+12137774445",   // toNumber
                null,             // overrideAgentId
                null,             // overrideAgentVersion
                null,             // agentOverride
                null,             // metadata
                null,             // retellLlmDynamicVariables
                null,             // customSipHeaders
                null));           // ignoreE164Validation
```

### Creating an agent

`AgentRequest` carries the full agent configuration (many optional fields); `response_engine` and
`voice_id` are the only ones the API requires.

```java
import io.github.qaiserarbi.retellai.model.agent.AgentRequest;
import io.github.qaiserarbi.retellai.model.common.ResponseEngine;
import io.github.qaiserarbi.retellai.model.common.ResponseEngineRetellLm;

ResponseEngine engine = new ResponseEngineRetellLm("llm_234sdertfsdsfsdf", null);
// Construct via the canonical constructor (remaining optional fields = null).
AgentResponse created = client.agents().createAgent(buildAgentRequest(engine, "retell-Cimo"));
```

> Note: fluent builders for the largest request records (e.g. `AgentRequest`,
> `RetellLlmRequest`) are a planned ergonomics enhancement.

### Working with polymorphic responses

The API's union types are modeled as Java `sealed` interfaces, so you can branch with
pattern-matching `switch`:

```java
import io.github.qaiserarbi.retellai.model.call.*;

V2CallResponse result = client.calls().getCall("call_123");
String summary = switch (result) {
    case V2PhoneCallResponse phone -> "Phone call from " + phone.fromNumber();
    case V2WebCallResponse web     -> "Web call " + web.callId();
};
```

## Error handling

Every non-2xx response throws a subclass of `RetellApiException`, which carries the HTTP status,
the parsed error message, the raw body, and the `x-request-id`:

```java
import io.github.qaiserarbi.retellai.exception.*;

try {
    client.agents().getAgent("does-not-exist", null);
} catch (RetellNotFoundException e) {        // 404
    // ...
} catch (RetellRateLimitException e) {       // 429
    e.retryAfterSeconds().ifPresent(this::backOff);
} catch (RetellApiException e) {             // any other API error
    log.warn("Retell error {} (request {}): {}", e.statusCode(), e.requestId().orElse("?"), e.apiMessage().orElse(""));
}
```

| Exception | HTTP status |
|---|---|
| `RetellBadRequestException` | 400 |
| `RetellAuthenticationException` | 401 |
| `RetellPaymentRequiredException` | 402 |
| `RetellPermissionException` | 403 |
| `RetellNotFoundException` | 404 |
| `RetellConflictException` | 409 |
| `RetellUnprocessableEntityException` | 422 |
| `RetellRateLimitException` | 429 (exposes `retryAfterSeconds()`) |
| `RetellServerException` | 5xx |
| `RetellConnectionException` | transport failure (no HTTP response) |

## Fault tolerance & resilience

Every request is wrapped in a configurable retry layer:

- **Automatic retries with exponential backoff + jitter** on transient failures — connection
  errors and the status codes 408, 429, 500, 502, 503, 504. Non-transient errors (400/401/404/422)
  are never retried.
- **`Retry-After` aware** — a `429`/`503` carrying a `Retry-After` header backs off for at least
  that long (capped at `maxDelay`).
- **Transport errors are wrapped** — connection refused, timeouts and TLS failures surface as
  `RetellConnectionException` (never a raw Spring/JDK exception), after retries are exhausted.

Defaults: up to 2 retries (3 total attempts), 500 ms base delay, 8 s cap. Tune or disable it:

```java
import io.github.qaiserarbi.retellai.RetryPolicy;
import java.time.Duration;

RetellClient client = RetellClient.builder()
        .apiKey("...")
        .maxRetries(4)                                   // quick override
        .retryPolicy(RetryPolicy.builder()               // or full control
                .maxRetries(4)
                .baseDelay(Duration.ofMillis(250))
                .maxDelay(Duration.ofSeconds(10))
                .retryableStatusCodes(java.util.Set.of(429, 500, 502, 503, 504))
                .retryOnConnectionError(true)
                .respectRetryAfter(true)
                .build())
        .build();

// Fail fast, no retries:
RetellClient strict = RetellClient.builder().apiKey("...").retryPolicy(RetryPolicy.none()).build();
```

> **Idempotency:** retries apply to all methods, including non-idempotent `POST`s. A request that
> timed out or failed with a 5xx may still have been processed by Retell, so a retry could
> duplicate it. Use `RetryPolicy.none()` (or a narrower status set) where that matters.

## Configuration

```java
RetellClient client = RetellClient.builder()
        .apiKey("...")
        .baseUrl("https://api.retellai.com")        // default
        .connectTimeout(Duration.ofSeconds(10))     // default
        .readTimeout(Duration.ofSeconds(120))       // default
        .userAgent("my-app/1.2.3")
        .customizeRestClient(b -> b.requestInterceptor(myInterceptor)) // advanced hook
        .build();
```

`RetellClient` is immutable and thread-safe — build one per API key and share it. Each resource
client (e.g. `client.agents()`) is a lazily-created, cached `@HttpExchange` proxy.

### Using it as a Spring bean

```java
@Bean
RetellClient retellClient(@Value("${retell.api-key}") String key) {
    return RetellClient.builder().apiKey(key).build();
}
```

## Resource groups

`agents()`, `agentVersions()`, `calls()`, `batchCalls()`, `phoneNumbers()`, `voices()`,
`knowledgeBases()`, `retellLlms()`, `conversationFlows()`, `conversationFlowComponents()`,
`chats()`, `chatAgents()`, `chatAgentVersions()`, `sms()`, `testCases()`, `batchTests()`,
`testRuns()`, `playground()`, `concurrency()`, `mcpTools()`, `exportRequests()`.

## Design notes

- **HTTP transport** is a JDK `java.net.http.HttpClient` running on a
  virtual-thread-per-task executor, wrapped by Spring's `RestClient` and exposed through
  `HttpServiceProxyFactory`-generated `@HttpExchange` proxies.
- **JSON** uses a single Jackson 3 `JsonMapper` configured for `snake_case` and to ignore unknown
  properties (so new Retell fields never break deserialization). Annotations are kept on the
  package-stable `com.fasterxml.jackson.annotation` types.
- **Pragmatic typing** — request/response roots and all the important polymorphic unions are fully
  typed. A small number of deeply-nested, response-only analytics structures that the spec itself
  leaves open-ended are exposed as `Map<String, Object>`.

## Building from source

```bash
./gradlew build      # compile, run tests, build jar + sources + javadoc
./gradlew test       # run the test suite only
```

## Disclaimer

This is an unofficial SDK and is not affiliated with or endorsed by Retell AI.
