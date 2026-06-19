//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.utilites;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    public static void validateTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void validateFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public static void validateEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void validateNotEquals(String actual, String expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    public static void validatePageUrl(WebDriver driver, String expectedUrl) {
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), expectedUrl);
    }
}
