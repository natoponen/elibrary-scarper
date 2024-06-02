package ru.rudn.ntoponen.elibraryscarper.app.api.metrics;

public class MetricsNotFoundException extends RuntimeException {
    public MetricsNotFoundException(String message) {
        super(message);
    }
}
