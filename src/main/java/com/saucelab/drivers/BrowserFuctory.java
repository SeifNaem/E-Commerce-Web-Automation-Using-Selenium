//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFuctory {
    public static WebDriver getBrowserType(String browser) {
        if (browser == null) {
            return null;
        } else {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments(new String[]{"start-maximized"});
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    return new ChromeDriver(chromeOptions);
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments(new String[]{"start-maximized"});
                    firefoxOptions.addArguments(new String[]{"--disable-extensions"});
                    firefoxOptions.addArguments(new String[]{"--disable-notifications"});
                    firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    return new FirefoxDriver(firefoxOptions);
                default:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments(new String[]{"start-maximized"});
                    edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    return new EdgeDriver(edgeOptions);
            }
        }
    }
}
