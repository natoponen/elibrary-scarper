package ru.rudn.ntoponen.elibraryscarper.app.api.metrics.calc;

import org.quartz.JobExecutionException;

public interface CalculateMetricsByFullNameInbound {
    /**
     * Рассчитать метрики по параметру поиска (автору)
     *
     * @param searchParam параметр поиска (автор)
     */
    void execute(String searchParam);
}
