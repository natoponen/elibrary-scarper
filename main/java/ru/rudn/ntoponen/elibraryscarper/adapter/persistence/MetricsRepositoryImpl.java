package ru.rudn.ntoponen.elibraryscarper.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.MetricsRepository;
import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MetricsRepositoryImpl implements MetricsRepository {
    private final MetricsJpaRepository metricsJpaRepository;

    @Override
    public Metrics save(Metrics metrics) {
        return metricsJpaRepository.save(metrics);
    }

    @Override
    public Optional<Metrics> findByAuthorAndDate(String author, LocalDate date) {
        return metricsJpaRepository.findByAuthorAndCalculationDate(author, date);
    }
}
