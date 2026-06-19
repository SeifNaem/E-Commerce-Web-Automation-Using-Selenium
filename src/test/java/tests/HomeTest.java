//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tests;

import com.saucelab.drivers.DriverManager;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest {
    private WebDriver driver;

    @Test(
            description = "Verify that items can be added to the cart and are displayed correctly in the cart page",
            dependsOnMethods = {"TC_5_assertItemsSortedLowToHigh"}
    )
    public void TC_3_addItemsToCart() {
        (new HomePage(this.driver)).addProduct("Sauce Labs Backpack").assertItemIsAdded("Sauce Labs Backpack").addProduct("Sauce Labs Bike Light").assertItemIsAdded("Sauce Labs Bike Light").addProduct("Sauce Labs Bolt T-Shirt").assertItemIsAdded("Sauce Labs Bolt T-Shirt").addProduct("Sauce Labs Fleece Jacket").assertItemIsAdded("Sauce Labs Fleece Jacket").addProduct("Sauce Labs Onesie").assertItemIsAdded("Sauce Labs Onesie").addProduct("Test.allTheThings() T-Shirt (Red)").assertItemIsAdded("Test.allTheThings() T-Shirt (Red)");
    }

    @Test(
            description = "Verify that items can be removed from the cart and are no longer displayed in the cart page",
            dependsOnMethods = {"TC_3_addItemsToCart"}
    )
    public void TC_4_removeItemsFromCart() {
        (new HomePage(this.driver)).removeProduct("Sauce Labs Onesie").assertItemIsRemoved("Sauce Labs Onesie").removeProduct("Test.allTheThings() T-Shirt (Red)").assertItemIsRemoved("Test.allTheThings() T-Shirt (Red)").removeProduct("Sauce Labs Backpack").assertItemIsRemoved("Sauce Labs Backpack").removeProduct("Sauce Labs Bike Light").assertItemIsRemoved("Sauce Labs Bike Light").removeProduct("Sauce Labs Bolt T-Shirt").assertItemIsRemoved("Sauce Labs Bolt T-Shirt").navigateToCartPage().assertCartIsOpened().assertCartIsNotEmpty();
    }

    @Test(
            description = "Verify that items can be sorted by price from low to high and are displayed in the correct order"
    )
    public void TC_5_assertItemsSortedLowToHigh() {
        (new HomePage(this.driver)).sortItems("Price (low to high)").assertSorting();
    }

    @Test(
            description = "Verify that a user can successfully log out from the application and is redirected to the login page",
            dependsOnMethods = {"TC_3_addItemsToCart"}
    )
    public void TC_6_assertLogout() {
        (new HomePage(this.driver)).logout().assertLogout();
    }

    @BeforeClass
    public void setUp() {
        this.driver = DriverManager.createDriver("edge");
        (new LoginPage(this.driver)).navigateToLoginPage();
        (new LoginPage(this.driver)).enterUsername("standard_user").enterPassword("secret_sauce").clickLogin().assertSuccessfulLogin();
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
