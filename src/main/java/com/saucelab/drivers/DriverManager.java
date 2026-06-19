//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.drivers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal();

    public static WebDriver createDriver(String browserName) {
        setDriver(BrowserFuctory.getBrowserType(browserName));
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            Assert.fail("WebDriver instance is not set for the current thread. Please initialize it before using.");
        }

        return (WebDriver)driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
