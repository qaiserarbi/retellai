package io.github.qaiserarbi.retellai.model.call;

import java.util.List;

/**
 * Latency statistics for a particular tracked metric of a call, measured in
 * milliseconds.
 */
public record CallLatency(
        Double p50,
        Double p90,
        Double p95,
        Double p99,
        Double max,
        Double min,
        Double num,
        List<Double> values) {
}
