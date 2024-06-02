package ru.rudn.ntoponen.elibraryscarper.app.impl.metrics.calc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.rudn.ntoponen.elibraryscarper.adapter.selenium.SeleniumAdapter;
import ru.rudn.ntoponen.elibraryscarper.app.api.metrics.MetricsRepository;
import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MetricsCalculationJob implements Job {
    @Value("${elibraryScarper.settings.mainPageUrl}")
    private String mainPageUrl;

    private final SeleniumAdapter seleniumAdapter;
    private final WebDriver webDriver;
    private final MetricsRepository metricsRepository;

    @Transactional
    @Override
    public void execute(JobExecutionContext context) {
        String author = context.getJobDetail().getKey().getName();
        log.info("Getting metrics of author {}", author);

        seleniumAdapter.getPageOutbound(mainPageUrl);
        sleep(2L);
        WebElement searchInput = webDriver.findElement(By.id("ftext"));
        searchInput.sendKeys(author);

        sleep(3L);
        WebElement searchButton = webDriver.findElement(By.className("butblue"));
        searchButton.click();

        List<WebElement> elements =
            webDriver.findElements(By.xpath(String.format("//i[contains(text(), '%s')]", author.substring(0, author.indexOf(" ")))));
        long citationsNum = 0;
        for (WebElement element : elements) {
            WebElement citationsElement = element.findElement(By.xpath("(./../../../td)[3]"));
            citationsNum += Long.parseLong(citationsElement.getText());
        }
        metricsRepository.save(new Metrics(author, (long) elements.size(), citationsNum, LocalDate.now()));
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            log.error("Error while awaiting before next step", e);
        }
    }
}
