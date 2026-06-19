//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.utilites;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import static com.saucelab.utilites.ElementAction.findElement;

public class Waits {
    public static WebElement waitForElementToBePresent(WebDriver driver, By locator) {
        return (WebElement)(new FluentWait(driver)).withTimeout(Duration.ofSeconds(10L)).pollingEvery(Duration.ofMillis(500L))
                .until(d -> {
            try {
                return driver.findElement(locator);
            } catch (NoSuchElementException var3) {
                return null;
            }
        });
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return (WebElement)(new FluentWait(driver)).withTimeout(Duration.ofSeconds(10L)).pollingEvery(Duration.ofMillis(500L)).until((d) -> {
            try {
                WebElement element = waitForElementToBePresent(driver, locator);
                return element.isDisplayed() ? element : null;
            } catch (NoSuchElementException var4) {
                return null;
            }
        });
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return (WebElement)(new FluentWait(driver)).withTimeout(Duration.ofSeconds(10L)).pollingEvery(Duration.ofMillis(500L)).until((d) -> {
            try {
                WebElement element = waitForElementToBePresent(driver, locator);
                return element.isEnabled() ? element : null;
            } catch (NoSuchElementException var4) {
                return null;
            }
        });
    }
}
