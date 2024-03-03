package ru.rudn.ntoponen.elibraryscarper.adapter.rest.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rudn.ntoponen.elibraryscarper.app.api.GetMetricsByAuthorInbound;
import ru.rudn.ntoponen.elibraryscarper.app.api.GetPageTitleInbound;

@RestController
@Slf4j
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class V1HealthController {
    private final GetPageTitleInbound getPageTitleInbound;
    private final GetMetricsByAuthorInbound getMetricsByAuthorInbound;
    private final MetricsDtoMapper metricsDtoMapper;

    @GetMapping("/health")
    public void healthCheck() {
        log.info("I am alive!");
    }

    @PostMapping("/page-title")
    public String getTitle(@RequestBody ParseRequestDto requestDto) {
        return getPageTitleInbound.execute(requestDto.getUrl());
    }

    @GetMapping("/get-metrics/by-author")
    public MetricsDto getMetrics(@RequestParam String author) {
        return metricsDtoMapper.mapToDto(getMetricsByAuthorInbound.execute(author));
    }
}
