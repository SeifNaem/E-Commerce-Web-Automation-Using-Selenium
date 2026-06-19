//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.pages;

import com.saucelab.utilites.ElementAction;
import com.saucelab.utilites.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    private final WebDriver driver;
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");
    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By itemPrice = By.cssSelector(".inventory_item_price");
    private final By totalPrice = By.cssSelector(".summary_total_label");
    private final By taxPrice = By.cssSelector(".summary_tax_label");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public CompletePage clickFinish() {
        ElementAction.clickElement(this.driver, this.finishButton);
        return new CompletePage(this.driver);
    }

    public OverviewPage clickCancel() {
        ElementAction.clickElement(this.driver, this.cancelButton);
        return this;
    }

    public HomePage assertCheckoutCancelled() {
        Validations.validatePageUrl(this.driver, "https://www.saucedemo.com/inventory.html");
        return new HomePage(this.driver);
    }

    public OverviewPage assertOverviewPageIsOpened() {
        Validations.validatePageUrl(this.driver, "https://www.saucedemo.com/checkout-step-two.html");
        return this;
    }

    public OverviewPage assertItemDetails(String expectedName, String expectedPrice) {
        Validations.validateEquals(ElementAction.getText(this.driver, this.itemName), expectedName, "The item name is not correct.");
        Validations.validateEquals(ElementAction.getText(this.driver, this.itemPrice), expectedPrice, "The item price is not correct.");
        return this;
    }
}
