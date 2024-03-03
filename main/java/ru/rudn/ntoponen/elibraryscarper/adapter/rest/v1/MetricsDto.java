package ru.rudn.ntoponen.elibraryscarper.adapter.rest.v1;

import lombok.Data;

@Data
public class MetricsDto {
    /**
     * Имя автора
     */
    private String author;
    /**
     * Число найденных публикаций
     */
    private int publicationsNum;
    /**
     * Число цитирований статей, в написании которых участвовал автор
     */
    private long citationsNum;
}
