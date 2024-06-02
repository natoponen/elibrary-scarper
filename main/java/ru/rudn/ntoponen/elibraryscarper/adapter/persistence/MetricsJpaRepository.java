package ru.rudn.ntoponen.elibraryscarper.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

import java.time.LocalDate;
import java.util.Optional;

public interface MetricsJpaRepository extends JpaRepository<Metrics, Long> {
    Optional<Metrics> findByAuthorAndCalculationDate(String author, LocalDate calculationDate);
}
