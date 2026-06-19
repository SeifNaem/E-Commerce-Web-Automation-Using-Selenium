//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.pages;

import com.saucelab.utilites.ElementAction;
import com.saucelab.utilites.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage enterFirstName(String fName) {
        ElementAction.clearElement(this.driver, this.firstName);
        ElementAction.sendData(this.driver, this.firstName, fName);
        return this;
    }

    public CheckoutPage enterLastName(String lName) {
        ElementAction.clearElement(this.driver, this.lastName);
        ElementAction.sendData(this.driver, this.lastName, lName);
        return this;
    }

    public CheckoutPage enterPostalCode(String pCode) {
        ElementAction.clearElement(this.driver, this.postalCode);
        ElementAction.sendData(this.driver, this.postalCode, pCode);
        return this;
    }

    public CheckoutPage clickContinue() {
        ElementAction.clickElement(this.driver, this.continueButton);
        return this;
    }

    public CheckoutPage assertCheckoutPageIsOpened() {
        Validations.validatePageUrl(this.driver, "https://www.saucedemo.com/checkout-step-one.html");
        return this;
    }

    public CheckoutPage assertErrorMessage(String expectedMessage) {
        By errorMessage = By.cssSelector("h3[data-test='error']");
        Validations.validateEquals(ElementAction.getText(this.driver, errorMessage), expectedMessage, "The error message is not correct.");
        return this;
    }
}
