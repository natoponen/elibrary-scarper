package ru.rudn.ntoponen.elibraryscarper.adapter.rest.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class V1HealthController {
    @GetMapping("/health")
    public void healthCheck() {
        log.info("I am alive!");
    }
}
