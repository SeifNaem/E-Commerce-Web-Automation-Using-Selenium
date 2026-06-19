//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scrolling {
    public static WebElement scrollToElement(WebDriver driver, By locator) {
        WebElement element = Waits.waitForElementToBePresent(driver, locator);
        if (element != null) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", new Object[]{ElementAction.findElement(driver, locator)});
        }

        return element;
    }
}
