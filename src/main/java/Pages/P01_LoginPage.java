package Pages;

import org.openqa.selenium.WebDriver;
//Website: https://www.saucedemo.com/
import org.openqa.selenium.By;
public class P01_LoginPage {
    WebDriver driver;

    //locators
    final private By usernameField = By.id("user-name");
    final private By passwordField = By.id("password");
    final private By loginButton = By.id("login-button");
    //error message locator for negative scenario
    final private By errorMessage = By.cssSelector("h3[data-test='error']");

    //constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods
    public void loginTest(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    //Assertions
    //Verify that the user is redirected to the Inventory page (URL contains /inventory.html)
    public boolean assertSuccessfulLogin() {
        return driver.getCurrentUrl().contains("/inventory.html");
    }

    //Verify that the displayed error message contains the text:
    //"Username and password do not match"
    public boolean assertInvalidLogin() {
        return driver.findElement(errorMessage).getText().contains("Username and password do not match");
    }

    // Verify that the displayed error message contains the text:
    //"Password is required"
    public boolean assertEmptyPassword() {
        return driver.findElement(errorMessage).getText().contains("Password is required");
    }
}
