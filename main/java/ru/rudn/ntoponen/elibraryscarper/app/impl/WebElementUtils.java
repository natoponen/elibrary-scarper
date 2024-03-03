package ru.rudn.ntoponen.elibraryscarper.app.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class WebElementUtils {
    protected WebElement getParent(WebElement child, int range) {
        if (range < 1) {
            throw new IllegalArgumentException("range cannot be lower than 1");
        }
        WebElement result = getParent(child);
        for (int i = 1; i < range; i++) {
            result = getParent(result);
        }
        return result;
    }

    protected WebElement getParent(WebElement child) {
        return child.findElement(By.xpath("./.."));
    }
}
