package ru.rudn.ntoponen.elibraryscarper.app.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import ru.rudn.ntoponen.elibraryscarper.adapter.selenium.SeleniumAdapter;
import ru.rudn.ntoponen.elibraryscarper.app.api.GetPageTitleInbound;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetPageTitleUseCase implements GetPageTitleInbound {
    private final SeleniumAdapter seleniumAdapter;
    private final WebDriver webDriver;

    @Override
    public String execute(String url) {
        log.info("Getting title of page {}", url);
        seleniumAdapter.getPageOutbound(url);
        return getTitle();
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private String getTitle() {
        return webDriver.getTitle();
    }
}
