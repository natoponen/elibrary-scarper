package ru.rudn.ntoponen.elibraryscarper.app.impl.metrics.calc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.utils.Key;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.calc.CalculateMetricsByFullNameInbound;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.MetricsRepository;
import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalculateMetricsByFullNameUseCase implements CalculateMetricsByFullNameInbound {
    private static final String METRICS_CALCULATION = "metricsCalculation";

    private final MetricsRepository metricsRepository;
    private final Scheduler scheduler;

    @Transactional
    @Override
    public void execute(String searchParam) {
        log.info("Starting metrics calculation for {} on date {}", searchParam, LocalDate.now());

        Optional<Metrics> calculatedMetrics = metricsRepository.findByAuthorAndDate(searchParam, LocalDate.now());
        Set<String> metricsCalculationJobKeys = getMetricsCalculationJobs();
        if (calculatedMetrics.isPresent() || metricsCalculationJobKeys.contains(searchParam)) {
            log.info("No need to calculate metrics for search param {} because it is calculating or already calculated", searchParam);
            return;
        }

        JobDetail job = JobBuilder.newJob(MetricsCalculationJob.class)
            .withIdentity(searchParam, METRICS_CALCULATION)
            .build();
        Trigger trigger = TriggerBuilder.newTrigger().forJob(job).startNow().build();
        log.info("Scheduling metrics calculation for {}", searchParam);
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            log.error("Error on creating metrics calculation for {} ", searchParam, e);
        }
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private Set<String> getMetricsCalculationJobs() {
        try {
            return scheduler.getJobKeys(GroupMatcher.groupEquals(METRICS_CALCULATION)).stream()
                .map(Key::getName)
                .collect(Collectors.toSet());
        } catch (SchedulerException e) {
            throw new IllegalStateException("Error on getting actual jobs for metrics calculation", e);
        }
    }
}
