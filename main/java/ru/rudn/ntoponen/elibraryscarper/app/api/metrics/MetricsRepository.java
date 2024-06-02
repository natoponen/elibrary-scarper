package ru.rudn.ntoponen.elibraryscarper.app.api.metrics;

import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

import java.time.LocalDate;
import java.util.Optional;

public interface MetricsRepository {
    /**
     * Сохранить метрики
     *
     * @param metrics метрики, которые необходимо сохранить
     * @return сохраненные метрики
     */
    Metrics save(Metrics metrics);

    /**
     * Найти метрики по автору и дате
     *
     * @param author автор, по которому считались метрики
     * @param date   дата, на которую считались метрики
     * @return найденная запись метрик
     */
    Optional<Metrics> findByAuthorAndDate(String author, LocalDate date);
}
