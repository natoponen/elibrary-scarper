package ru.rudn.ntoponen.elibraryscarper.app.api.metrics;

import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

import java.time.LocalDate;

public interface GetMetricsInbound {
    /**
     * Получить метрики по имени автора и дате
     *
     * @param author имя автора по которому будет осуществляться поиск
     * @param date   дата расчета на которую будут искаться метрики
     * @return найденные метрики
     */
    Metrics getByAuthorAndDate(String author, LocalDate date);
}
