package ru.rudn.ntoponen.elibraryscarper.fw.spring;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "ru.rudn.ntoponen.elibraryscarper.domain")
public class JpaConfiguration {
}
