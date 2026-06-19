//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.pages;

import com.saucelab.utilites.ElementAction;
import com.saucelab.utilites.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;
    private final By checkout = By.id("checkout");
    private final By continueShopping = By.id("continue-shopping");
    private final By itemsInCart = By.className("shopping_cart_badge");
    private final By productName = By.cssSelector(".inventory_item_name");
    private final By productPrice = By.cssSelector(".inventory_item_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return ElementAction.getText(this.driver, this.productName);
    }

    public String getProductPrice() {
        return ElementAction.getText(this.driver, this.productPrice);
    }

    public CheckoutPage clickCheckout() {
        ElementAction.clickElement(this.driver, this.checkout);
        return new CheckoutPage(this.driver);
    }

    public HomePage clickContinueShopping() {
        ElementAction.clickElement(this.driver, this.continueShopping);
        return new HomePage(this.driver);
    }

    public CartPage assertCartIsNotEmpty() {
        Validations.validateTrue(ElementAction.isElementDisplayed(this.driver, this.itemsInCart), "The cart is Not empty.");
        return this;
    }

    public CartPage assertCartIsOpened() {
        Validations.validatePageUrl(this.driver, "https://www.saucedemo.com/cart.html");
        return new CartPage(this.driver);
    }

    public CartPage assertProductDetails(String procuctName, String productPrice) {
        Validations.validateEquals(this.getProductName(), procuctName, "The product name is not correct.");
        Validations.validateEquals(this.getProductPrice(), productPrice, "The product price is not correct.");
        return this;
    }
}
