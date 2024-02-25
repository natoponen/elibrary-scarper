package ru.rudn.ntoponen.elibraryscarper.adapter.rest.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rudn.ntoponen.elibraryscarper.app.api.GetPageTitleInbound;

@RestController
@Slf4j
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class V1HealthController {
    private final GetPageTitleInbound getPageTitleInbound;

    @GetMapping("/health")
    public void healthCheck() {
        log.info("I am alive!");
    }

    @GetMapping("/page-title")
    public String getTitle(@RequestParam String url) {
        return getPageTitleInbound.execute(url);
    }
}
