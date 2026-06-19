//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.utilites;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
}
