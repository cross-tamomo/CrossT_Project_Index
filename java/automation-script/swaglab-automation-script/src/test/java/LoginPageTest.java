import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (loginPage != null) {
            driver.quit();
        }
    }

    @Test(enabled = true)
    void loginValidCredentialsTest() {
        loginPage.validLoginCredentials("standard_user", "secret_sauce");
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(loginPage.getCurrentUrl(), expectedUrl);
    }
}
