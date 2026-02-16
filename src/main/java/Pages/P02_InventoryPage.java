package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_InventoryPage {
    WebDriver driver;
    //locators
    //page title locator
    final private By pageTitle = By.cssSelector("div[class='app_logo']");
    //cart icon locator
    final private By cartIcon = By.id("shopping_cart_container");
    //6 product items locator
    final private By productItems = By.className("inventory_item");

    //constructor
    public P02_InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    //methods



    //Assertions
    //Verify that the page title is "Swag Labs"
    public boolean assertPageTitle() {
        return driver.findElement(pageTitle).getText().equals("Swag Labs");
    }

    //Verify that the cart icon is displayed
    public boolean assertCartIconDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    //Verify that there are 6 product items displayed on the page
    public boolean assertProductItemsCount() {
        return driver.findElements(productItems).size() == 6;
    }
}
