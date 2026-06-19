//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.pages;

import com.saucelab.utilites.BrowserActions;
import com.saucelab.utilites.ElementAction;
import com.saucelab.utilites.SoftAssertion;
import com.saucelab.utilites.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage() {
        BrowserActions.navigateToUrl(this.driver, "https://www.saucedemo.com/");
        return this;
    }

    public String getPageTitle() {
        return BrowserActions.getTitle(this.driver);
    }

    public String getCurrentUrl() {
        return BrowserActions.getCurrentUrl(this.driver);
    }

    public String getErrorMessage() {
        return ElementAction.getText(this.driver, this.errorMessage);
    }

    public LoginPage enterUsername(String username) {
        ElementAction.sendData(this.driver, this.usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        ElementAction.sendData(this.driver, this.passwordInput, password);
        return this;
    }

    public LoginPage clickLogin() {
        ElementAction.clickElement(this.driver, this.loginButton);
        return this;
    }

    public LoginPage assertLoginPageURL() {
        SoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentUrl(this.driver), "https://www.saucedemo.com/inventory.html", "User is not on the login page");
        return this;
    }

    public LoginPage assertLoginPageTitle() {
        SoftAssertion.softAssertion.assertEquals(BrowserActions.getTitle(this.driver), "Swag Labs", "User is not on the login page");
        return this;
    }

    public LoginPage assertSuccessfulLoginSoft() {
        this.assertLoginPageURL().assertLoginPageTitle();
        return this;
    }

    public LoginPage assertSuccessfulLogin() {
        Validations.validatePageUrl(this.driver, "https://www.saucedemo.com/inventory.html");
        return this;
    }

    public LoginPage assertUnsuccessfulLogin(String expectedErrorMessage) {
        Validations.validateEquals(this.getErrorMessage(), expectedErrorMessage, "Login was not successful");
        return this;
    }
}
