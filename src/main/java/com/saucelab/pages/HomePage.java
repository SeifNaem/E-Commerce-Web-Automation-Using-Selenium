//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.pages;

import com.saucelab.utilites.BrowserActions;
import com.saucelab.utilites.ElementAction;
import com.saucelab.utilites.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage {
    private final WebDriver driver;
    private final By cartIcon = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage navigateToCartPage() {
        ElementAction.clickElement(this.driver, this.cartIcon);
        return new CartPage(this.driver);
    }

    public HomePage navigateToHomePage() {
        BrowserActions.navigateToUrl(this.driver, "https://www.saucedemo.com/inventory.html");
        return this;
    }

    public HomePage addProduct(String productName) {
        By buttonLocator = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[text()='" + productName + "']"));
        ElementAction.clickElement(this.driver, buttonLocator);
        return this;
    }

    public HomePage removeProduct(String productName) {
        By buttonLocator = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[text()='" + productName + "']"));
        ElementAction.clickElement(this.driver, buttonLocator);
        return this;
    }

    public HomePage sortItems(String sortOption) {
        By sortDropdown = By.className("product_sort_container");
        ElementAction.clickElement(this.driver, sortDropdown);
        By optionLocator = By.xpath("//option[text()='" + sortOption + "']");
        ElementAction.clickElement(this.driver, optionLocator);
        return this;
    }

    public String getItemPrice(int itemNum) {
        By itemlocator = By.xpath("(//div[@class='inventory_item_price'])[" + itemNum + "]");
        By item2 = By.xpath("//*[@id=\"inventory_container\"]/div/div[" + itemNum + "]/div[2]/div[2]/div/text()[2]");
        return ElementAction.getText(this.driver, itemlocator);
    }

    public HomePage assertSorting() {
        Validations.validateEquals(this.getItemPrice(1), "$7.99", "The items are not sorted correctly.");
        Validations.validateEquals(this.getItemPrice(2), "$9.99", "The items are not sorted correctly.");
        Validations.validateEquals(this.getItemPrice(3), "$15.99", "The items are not sorted correctly.");
        return this;
    }

    public By menueOptions(String item) {
        By menuButton = By.id("react-burger-menu-btn");
        ElementAction.clickElement(this.driver, menuButton);
        By ilement = By.xpath("//nav[@class='bm-item-list']//a[text()='" + item + "']");
        return ilement;
    }

    public HomePage logout() {
        ElementAction.clickElement(this.driver, this.menueOptions("Logout"));
        return this;
    }

    public HomePage assertItemIsAdded(String productName) {
        By buttonLocator = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[text()='" + productName + "']"));
        Validations.validateEquals(ElementAction.getText(this.driver, buttonLocator), "Remove", "The item was not added to the cart successfully.");
        return this;
    }

    public HomePage assertItemIsRemoved(String productName) {
        By buttonLocator = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[text()='" + productName + "']"));
        Validations.validateEquals(ElementAction.getText(this.driver, buttonLocator), "Add to cart", "The item was not removed from the cart successfully.");
        return this;
    }

    public HomePage assertLogout() {
        Validations.validateEquals(BrowserActions.getCurrentUrl(this.driver), "https://www.saucedemo.com/", "Logout was not successful.");
        return this;
    }

    public HomePage assertHomePageIsOpened() {
        Validations.validatePageUrl(this.driver, "https://www.saucedemo.com/inventory.html");
        return this;
    }
}
