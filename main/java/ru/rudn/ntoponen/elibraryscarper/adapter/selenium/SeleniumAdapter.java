package ru.rudn.ntoponen.elibraryscarper.adapter.selenium;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import ru.rudn.ntoponen.elibraryscarper.app.api.GetPageOutbound;

@Component
@RequiredArgsConstructor
@Slf4j
public class SeleniumAdapter implements GetPageOutbound {
    private final WebDriver webDriver;

    @Override
    public void getPageOutbound(String url) {
        log.info("Getting page by url {}", url);
        webDriver.get(url);
    }
}
