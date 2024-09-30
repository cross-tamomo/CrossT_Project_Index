import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    private static final String EXPECTED_TITLE = "Swag Labs";
    protected WebDriver webDriver;

    // Locators
    private By usernameBy = By.id("user-name");
    private By passwordBy = By.id("password");
    private By loginButtonBy = By.id("login-button");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        navigateToLoginPage();
    }

    public void navigateToLoginPage() throws IllegalStateException {
        webDriver.get(LOGIN_PAGE_URL);
        validateLoginPage();
    }

    private void validateLoginPage() {
        if (!EXPECTED_TITLE.equals(webDriver.getTitle())) {
            String loginPageErrorMsg = "This is not the Login page. Current page is ";
            throw new IllegalStateException(loginPageErrorMsg + webDriver.getCurrentUrl());
        }
    }

    public void enterUsername(String username) {
        WebElement usernameField = webDriver.findElement(usernameBy);
        usernameField.sendKeys(username.trim());
    }

    public void enterPassword(String password) {
        WebElement passwordField = webDriver.findElement(passwordBy);
        passwordField.sendKeys(password.trim());
    }

    public void clickLoginButton() {
        WebElement loginButton = webDriver.findElement(loginButtonBy);
        loginButton.click();
    }

    public void validLoginCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}