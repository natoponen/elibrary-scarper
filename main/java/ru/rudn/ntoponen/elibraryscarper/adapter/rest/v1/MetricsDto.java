package ru.rudn.ntoponen.elibraryscarper.adapter.rest.v1;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MetricsDto {
    /**
     * Имя автора
     */
    private String author;
    /**
     * Число найденных публикаций
     */
    private Long publicationsNum;
    /**
     * Число цитирований статей, в написании которых участвовал автор
     */
    private Long citationsNum;
    /**
     * Дата, на которую был выполнен расчет
     */
    private LocalDate calculationDate;
}
