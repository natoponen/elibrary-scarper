package ru.rudn.ntoponen.elibraryscarper.app.api;

import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

public interface GetMetricsByAuthorInbound {
    /**
     * Получить метрики по имени автора
     *
     * @param author имя автора по которому будет осуществляться поиск
     * @return рассчитанные метрики
     */
    public Metrics execute(String author);
}
