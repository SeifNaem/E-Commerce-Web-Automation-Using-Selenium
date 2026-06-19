//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.pages;

import com.saucelab.utilites.ElementAction;
import com.saucelab.utilites.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {
    private final WebDriver driver;
    private final By completeMessage = By.cssSelector(".complete-header");
    private final By backHome = By.id("back-to-products");

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertOrderCompleted() {
        Validations.validateEquals(ElementAction.getText(this.driver, this.completeMessage), "Thank you for your order!", "The order is not completed.");
    }

    public HomePage clickBackHome() {
        ElementAction.clickElement(this.driver, this.backHome);
        return new HomePage(this.driver);
    }
}
