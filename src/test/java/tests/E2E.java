//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tests;

import com.saucelab.drivers.DriverManager;
import com.saucelab.pages.CompletePage;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.LoginPage;
import com.saucelab.pages.OverviewPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class E2E {
    private WebDriver driver;

    @Test(
            description = "Verify that a user can successfully complete an end-to-end purchase flow, including login, adding products to the cart, checking out, and confirming the order."
    )
    public void E2E() {
        (new LoginPage(this.driver)).navigateToLoginPage().enterUsername("standard_user").enterPassword("secret_sauce").clickLogin();
        (new HomePage(this.driver)).addProduct("Sauce Labs Backpack").addProduct("Sauce Labs Bike Light").removeProduct("Sauce Labs Bike Light").navigateToCartPage().clickCheckout().enterFirstName("John").enterLastName("Doe").enterPostalCode("12345").clickContinue();
        (new OverviewPage(this.driver)).clickFinish();
        (new CompletePage(this.driver)).clickBackHome().logout().assertLogout();
    }

    @BeforeClass
    public void setUp() {
        this.driver = DriverManager.createDriver("edge");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
