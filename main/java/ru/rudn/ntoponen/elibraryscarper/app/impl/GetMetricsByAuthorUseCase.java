package ru.rudn.ntoponen.elibraryscarper.app.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import ru.rudn.ntoponen.elibraryscarper.adapter.selenium.SeleniumAdapter;
import ru.rudn.ntoponen.elibraryscarper.app.api.GetMetricsByAuthorInbound;
import ru.rudn.ntoponen.elibraryscarper.domain.Metrics;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetMetricsByAuthorUseCase implements GetMetricsByAuthorInbound {
    private static final String STARTER_PAGE_URL = "https://elibrary.ru/defaultx.asp?";

    private final SeleniumAdapter seleniumAdapter;
    private final WebDriver webDriver;

    @Override
    public Metrics execute(String author) {
        log.info("Getting metrics of author {}", author);
        // Переходим на начальную страницу
        seleniumAdapter.getPageOutbound(STARTER_PAGE_URL);
        // Находим поле для ввода и вводим переданного автора
        WebElement searchInput = webDriver.findElement(By.id("ftext"));
        searchInput.sendKeys(author);
        // Нажимаем на конопку "Найти"
        WebElement searchButton = webDriver.findElement(By.className("butblue"));
        searchButton.click();
        // Получаем элементы, содеражие фамилию автора
        List<WebElement> elements =
            webDriver.findElements(By.xpath(String.format("//i[contains(text(), '%s')]", author.substring(0, author.indexOf(" ")))));
        // Складываем показатели цитирования из каждой строки, где нашли автора в описании
        long citationsNum = 0;
        for (WebElement element : elements) {
            WebElement citationsElement = element.findElement(By.xpath("(./../../../td)[3]"));
            citationsNum += Long.parseLong(citationsElement.getText());
        }
        return new Metrics(author, elements.size(), citationsNum);
    }
}
