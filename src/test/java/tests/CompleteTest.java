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

public class CompleteTest {
    private WebDriver driver;

    @Test(
            description = "Verify that the order completion message is displayed correctly after finishing the checkout process."
    )
    public void TC_1_verifyOrderCompletion() {
        (new CompletePage(this.driver)).assertOrderCompleted();
    }

    @Test(
            description = "Verify that the 'Back Home' button on the order completion page navigates the user back to the home page."
    )
    public void TC_2_verifyBackToHomeButton() {
        (new CompletePage(this.driver)).clickBackHome().assertHomePageIsOpened();
    }

    @BeforeClass
    public void setUp() {
        this.driver = DriverManager.createDriver("edge");
        (new LoginPage(this.driver)).navigateToLoginPage();
        (new LoginPage(this.driver)).enterUsername("standard_user").enterPassword("secret_sauce").clickLogin();
        (new HomePage(this.driver)).addProduct("Sauce Labs Backpack").assertItemIsAdded("Sauce Labs Backpack").navigateToCartPage().clickCheckout().enterFirstName("John").enterLastName("Doe").enterPostalCode("12345").clickContinue();
        (new OverviewPage(this.driver)).clickFinish();
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
