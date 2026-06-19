//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tests;

import com.saucelab.drivers.DriverManager;
import com.saucelab.pages.CheckoutPage;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {
    private WebDriver driver;

    @Test(
            description = "Verify that user can proceed to checkout with valid information",
            dependsOnMethods = {"TC_4_checkoutWithEmptyPostalCode"}
    )
    public void TC_1_checkoutWithValidInformation() {
        (new CheckoutPage(this.driver)).enterFirstName("John").enterLastName("Doe").enterPostalCode("12345").clickContinue();
    }

    @Test(
            description = "Verify that user cannot proceed to checkout with empty first name"
    )
    public void TC_2_checkoutWithEmptyFirstName() {
        (new CheckoutPage(this.driver)).enterFirstName("").clickContinue().assertErrorMessage("Error: First Name is required");
    }

    @Test(
            description = "Verify that user cannot proceed to checkout with empty last name"
    )
    public void TC_3_checkoutWithEmptyLastName() {
        (new CheckoutPage(this.driver)).enterFirstName("John").enterLastName("").clickContinue().assertErrorMessage("Error: Last Name is required");
    }

    @Test(
            description = "Verify that user cannot proceed to checkout with empty postal code"
    )
    public void TC_4_checkoutWithEmptyPostalCode() {
        (new CheckoutPage(this.driver)).enterFirstName("John").enterLastName("Doe").enterPostalCode("").clickContinue().assertErrorMessage("Error: Postal Code is required");
    }

    @BeforeClass
    public void setUp() {
        this.driver = DriverManager.createDriver("edge");
        (new LoginPage(this.driver)).navigateToLoginPage();
        (new LoginPage(this.driver)).enterUsername("standard_user").enterPassword("secret_sauce").clickLogin();
        (new HomePage(this.driver)).addProduct("Sauce Labs Backpack").assertItemIsAdded("Sauce Labs Backpack").navigateToCartPage().assertCartIsNotEmpty().clickCheckout().assertCheckoutPageIsOpened();
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
