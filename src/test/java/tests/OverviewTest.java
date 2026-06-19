//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tests;

import com.saucelab.drivers.DriverManager;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.LoginPage;
import com.saucelab.pages.OverviewPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OverviewTest {
    private WebDriver driver;

    @Test(
            description = "Verify that the cancel button on the overview page successfully cancels the checkout process and redirects the user back to the cart page"
    )
    public void TC_1_checkCancelButtom() {
        (new OverviewPage(this.driver)).clickCancel().assertCheckoutCancelled();
    }

    @BeforeClass
    public void setUp() {
        this.driver = DriverManager.createDriver("edge");
        (new LoginPage(this.driver)).navigateToLoginPage();
        (new LoginPage(this.driver)).enterUsername("standard_user").enterPassword("secret_sauce").clickLogin();
        (new HomePage(this.driver)).addProduct("Sauce Labs Backpack").assertItemIsAdded("Sauce Labs Backpack").navigateToCartPage().clickCheckout().enterFirstName("John").enterLastName("Doe").enterPostalCode("12345").clickContinue();
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
