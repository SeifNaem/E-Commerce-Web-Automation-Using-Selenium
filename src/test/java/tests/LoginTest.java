//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tests;

import com.saucelab.drivers.DriverManager;
import com.saucelab.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @Test(
            description = "Verify that a user can successfully log in with valid credentials"
    )
    public void TC_1_loginWithValidUsernameAndPassword() {
        (new LoginPage(this.driver)).enterUsername("standard_user").enterPassword("secret_sauce").clickLogin().assertSuccessfulLogin();
    }

    @Test(
            description = "Verify that a user cannot log in with invalid credentials and receives an appropriate error message"
    )
    public void TC_2_loginWithInvalidUsernameAndPassword() {
        (new LoginPage(this.driver)).enterUsername("invalid_user").enterPassword("invalid_password").clickLogin().assertUnsuccessfulLogin("Epic sadface: Username and password do not match any user in this service");
    }

    @Test(
            description = "Verify that a user cannot log in with a valid username and an empty password and receives an appropriate error message"
    )
    public void TC_3_loginWithValidUsernameAndEemptyPassword() {
        (new LoginPage(this.driver)).enterUsername("standard_user").enterPassword("").clickLogin().assertUnsuccessfulLogin("Epic sadface: Password is required");
    }

    @BeforeMethod
    public void setUp() {
        this.driver = DriverManager.createDriver("edge");
        (new LoginPage(this.driver)).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }
}
