package ru.rudn.ntoponen.elibraryscarper.adapter.rest.v1;

import org.mapstruct.Mapper;
import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

@Mapper
public interface MetricsDtoMapper {
    MetricsDto mapToDto(Metrics source);
}
