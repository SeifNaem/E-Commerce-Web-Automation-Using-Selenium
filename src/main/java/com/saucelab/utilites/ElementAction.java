//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementAction {
    public static void sendData(WebDriver driver, By locator, String data) {
        Waits.waitForElementToBePresent(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        Waits.waitForElementToBeVisible(driver, locator);
        findElement(driver, locator).sendKeys(new CharSequence[]{data});
    }

    public static void clickElement(WebDriver driver, By locator) {
        Waits.waitForElementToBePresent(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        Waits.waitForElementToBeClickable(driver, locator);
        findElement(driver, locator).click();
    }

    public static void clearElement(WebDriver driver, By locator) {
        Waits.waitForElementToBePresent(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        Waits.waitForElementToBeClickable(driver, locator);
        findElement(driver, locator).clear();
    }

    public static String getText(WebDriver driver, By locator) {
        Waits.waitForElementToBePresent(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        Waits.waitForElementToBeVisible(driver, locator);
        return findElement(driver, locator).getText();
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        Waits.waitForElementToBePresent(driver, locator);
        return driver.findElement(locator);
    }

    public static boolean isElementDisplayed(WebDriver driver, By itemsInCart) {
        return Waits.waitForElementToBePresent(driver, itemsInCart) != null;
    }
}
