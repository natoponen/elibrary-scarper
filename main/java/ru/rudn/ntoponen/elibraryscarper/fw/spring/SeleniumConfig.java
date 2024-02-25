package ru.rudn.ntoponen.elibraryscarper.fw.spring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {
    @Bean
    public WebDriver initWebDriver() {
        return new ChromeDriver();
    }
}
