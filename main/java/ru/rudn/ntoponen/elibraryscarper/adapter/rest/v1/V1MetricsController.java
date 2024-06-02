package ru.rudn.ntoponen.elibraryscarper.adapter.rest.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.calc.CalculateMetricsByFullNameInbound;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.GetMetricsInbound;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class V1MetricsController {
    private final CalculateMetricsByFullNameInbound calculateMetricsByFullNameInbound;
    private final GetMetricsInbound getMetricsInbound;
    private final MetricsDtoMapper metricsDtoMapper;

    @PostMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    public void calculate(@RequestParam String searchParam) {
        calculateMetricsByFullNameInbound.execute(searchParam);
    }

    @GetMapping("/characteristics")
    @ResponseStatus(HttpStatus.OK)
    public MetricsDto getMetrics(@RequestParam String searchParam) {
        return metricsDtoMapper.mapToDto(getMetricsInbound.getByAuthorAndDate(searchParam, LocalDate.now()));
    }
}
