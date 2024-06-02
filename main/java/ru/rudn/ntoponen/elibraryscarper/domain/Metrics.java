package ru.rudn.ntoponen.elibraryscarper.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "metrics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Metrics extends DomainObject {
    /**
     * Имя автора
     */
    @Column(name = "author", nullable = false)
    private String author;
    /**
     * Число найденных публикаций
     */
    @Column(name = "publications_num")
    private Long publicationsNum;
    /**
     * Число цитирований статей, в написании которых участвовал автор
     */
    @Column(name = "citations_num")
    private Long citationsNum;
    /**
     * Дата, на которую был выполнен расчет
     */
    @Column(name = "calculation_date", nullable = false)
    private LocalDate calculationDate;
}
