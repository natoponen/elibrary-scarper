package ru.rudn.ntoponen.elibraryscarper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metrics {
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
