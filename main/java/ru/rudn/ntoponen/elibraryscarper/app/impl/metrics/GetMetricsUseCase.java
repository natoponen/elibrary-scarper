package ru.rudn.ntoponen.elibraryscarper.app.impl.metrics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.GetMetricsInbound;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.MetricsNotFoundException;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.MetricsRepository;
import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetMetricsUseCase implements GetMetricsInbound {
    private final MetricsRepository metricsRepository;

    @Override
    public Metrics getByAuthorAndDate(String author, LocalDate date) {
        log.info("Getting metrics for {} on date {}", author, date);
        return metricsRepository.findByAuthorAndDate(author, date)
            .orElseThrow(() -> new MetricsNotFoundException(String.format("Metrics for %s on date %s not found", author, date)));
    }
}
