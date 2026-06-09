package io.github.qaiserarbi.retellai;

import io.github.qaiserarbi.retellai.exception.RetellBadRequestException;
import io.github.qaiserarbi.retellai.exception.RetellConnectionException;
import io.github.qaiserarbi.retellai.exception.RetellServerException;
import io.github.qaiserarbi.retellai.model.voice.VoiceResponse;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Verifies the SDK's retry/backoff and transport-error wrapping behaviour. */
class ResilienceTest {

    private HttpServer server;
    private final AtomicInteger calls = new AtomicInteger();

    @AfterEach
    void stop() {
        if (server != null) {
            server.stop(0);
        }
    }

    /** Starts a stub that returns the queued status codes in order (defaulting to 200 once drained). */
    private RetellClient clientFor(Queue<Integer> statuses, RetryPolicy policy) throws IOException {
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/get-voice/", exchange -> {
            calls.incrementAndGet();
            Integer status = statuses.poll();
            int code = status == null ? 200 : status;
            String body = code == 200
                    ? "{\"voice_id\":\"v1\",\"voice_name\":\"Cimo\"}"
                    : "{\"status\":\"error\",\"message\":\"transient\"}";
            byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(code, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.close();
        });
        server.start();
        return RetellClient.builder()
                .apiKey("test-key")
                .baseUrl("http://localhost:" + server.getAddress().getPort())
                .retryPolicy(policy)
                .build();
    }

    private static RetryPolicy fastPolicy(int maxRetries) {
        return RetryPolicy.builder()
                .maxRetries(maxRetries)
                .baseDelay(Duration.ofMillis(5))
                .maxDelay(Duration.ofMillis(20))
                .build();
    }

    @Test
    void retriesTransient5xxThenSucceeds() throws IOException {
        Queue<Integer> statuses = new ConcurrentLinkedQueue<>(java.util.List.of(503, 503));
        RetellClient client = clientFor(statuses, fastPolicy(3));

        VoiceResponse voice = client.voices().getVoice("x");

        assertEquals("v1", voice.voiceId());
        assertEquals(3, calls.get()); // two failures + one success
    }

    @Test
    void retries429ThenSucceeds() throws IOException {
        Queue<Integer> statuses = new ConcurrentLinkedQueue<>(java.util.List.of(429));
        RetellClient client = clientFor(statuses, fastPolicy(3));

        assertEquals("v1", client.voices().getVoice("x").voiceId());
        assertEquals(2, calls.get());
    }

    @Test
    void doesNotRetryNonTransientStatus() throws IOException {
        Queue<Integer> statuses = new ConcurrentLinkedQueue<>(java.util.List.of(400));
        RetellClient client = clientFor(statuses, fastPolicy(3));

        assertThrows(RetellBadRequestException.class, () -> client.voices().getVoice("x"));
        assertEquals(1, calls.get()); // 400 is not retryable
    }

    @Test
    void retriesExhaustedSurfacesTypedApiException() throws IOException {
        Queue<Integer> statuses = new ConcurrentLinkedQueue<>(java.util.List.of(500, 500, 500, 500));
        RetellClient client = clientFor(statuses, fastPolicy(2));

        assertThrows(RetellServerException.class, () -> client.voices().getVoice("x"));
        assertEquals(3, calls.get()); // initial + 2 retries, all 500
    }

    @Test
    void retriesDisabledFailsFast() throws IOException {
        Queue<Integer> statuses = new ConcurrentLinkedQueue<>(java.util.List.of(503));
        RetellClient client = clientFor(statuses, RetryPolicy.none());

        assertThrows(RetellServerException.class, () -> client.voices().getVoice("x"));
        assertEquals(1, calls.get());
    }

    @Test
    void connectionFailureIsWrapped() throws IOException {
        int deadPort;
        try (ServerSocket s = new ServerSocket(0)) {
            deadPort = s.getLocalPort();
        } // socket closed -> nothing is listening on deadPort

        RetellClient client = RetellClient.builder()
                .apiKey("test-key")
                .baseUrl("http://localhost:" + deadPort)
                .retryPolicy(fastPolicy(1))
                .build();

        assertThrows(RetellConnectionException.class, () -> client.voices().getVoice("x"));
    }
}
