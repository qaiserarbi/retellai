package io.github.qaiserarbi.retellai;

import io.github.qaiserarbi.retellai.exception.RetellAuthenticationException;
import io.github.qaiserarbi.retellai.exception.RetellRateLimitException;
import io.github.qaiserarbi.retellai.exception.RetellUnprocessableEntityException;
import io.github.qaiserarbi.retellai.model.voice.VoiceResponse;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * End-to-end transport tests: a stubbed HTTP server (no real Retell network calls) verifies that
 * the {@link RetellClient} sends the bearer token, deserializes a happy-path response, and maps
 * error status codes to the typed exception hierarchy.
 */
class HttpBehaviorTest {

    private HttpServer server;
    private RetellClient client;
    private final AtomicReference<String> lastAuthHeader = new AtomicReference<>();

    @BeforeEach
    void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/get-voice/", exchange -> {
            lastAuthHeader.set(exchange.getRequestHeaders().getFirst("Authorization"));
            String id = exchange.getRequestURI().getPath().substring("/get-voice/".length());
            switch (id) {
                case "401" -> respond(exchange, 401, "{\"status\":\"error\",\"message\":\"API key is missing or invalid.\"}", null);
                case "429" -> respond(exchange, 429, "{\"status\":\"error\",\"message\":\"rate limited\"}", "30");
                case "422" -> respond(exchange, 422, "{\"status\":\"error\",\"message\":\"bad asset\"}", null);
                default -> respond(exchange, 200, "{\"voice_id\":\"v1\",\"voice_name\":\"Cimo\",\"age\":\"Young\"}", null);
            }
        });
        server.start();

        client = RetellClient.builder()
                .apiKey("test-key")
                .baseUrl("http://localhost:" + server.getAddress().getPort())
                .build();
    }

    @AfterEach
    void stopServer() {
        server.stop(0);
    }

    private static void respond(com.sun.net.httpserver.HttpExchange exchange, int status, String body, String retryAfter) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        if (retryAfter != null) {
            exchange.getResponseHeaders().add("Retry-After", retryAfter);
        }
        exchange.sendResponseHeaders(status, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }

    @Test
    void happyPath_deserializesAndSendsBearerToken() {
        VoiceResponse voice = client.voices().getVoice("ok");

        assertEquals("v1", voice.voiceId());
        assertEquals("Cimo", voice.voiceName());
        assertEquals("Young", voice.age());
        assertEquals("Bearer test-key", lastAuthHeader.get());
    }

    @Test
    void unauthorized_mapsToAuthenticationException() {
        RetellAuthenticationException ex =
                assertThrows(RetellAuthenticationException.class, () -> client.voices().getVoice("401"));
        assertEquals(401, ex.statusCode());
        assertTrue(ex.apiMessage().orElse("").contains("API key"));
    }

    @Test
    void rateLimited_mapsToRateLimitExceptionWithRetryAfter() {
        RetellRateLimitException ex =
                assertThrows(RetellRateLimitException.class, () -> client.voices().getVoice("429"));
        assertEquals(429, ex.statusCode());
        assertEquals(30L, ex.retryAfterSeconds().orElseThrow());
    }

    @Test
    void unprocessable_mapsToValidationException() {
        RetellUnprocessableEntityException ex =
                assertThrows(RetellUnprocessableEntityException.class, () -> client.voices().getVoice("422"));
        assertEquals(422, ex.statusCode());
    }
}
