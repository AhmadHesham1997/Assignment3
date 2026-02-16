package Test;

import Base.BaseTest;
import Pages.P01_LoginPage;
import Pages.P02_InventoryPage;
import Util.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {
    //instance of the P01_LoginPage class to use its methods in our test cases
    P01_LoginPage LoginPage;
    //instance of the InventoryPage class to use its methods in our test cases
    P02_InventoryPage InventoryPage;

    @Test(dataProvider = "validLoginData", dataProviderClass = DataDriven.class)
    public void inventoryPageTests(String username, String password, String type) {

        LoginPage = new P01_LoginPage(driver);
        InventoryPage = new P02_InventoryPage(driver);

        LoginPage.loginTest(username, password);

        Assert.assertTrue(InventoryPage.assertPageTitle(), "Failed to navigate to Inventory page after valid login!");
        Assert.assertTrue(InventoryPage.assertCartIconDisplayed(), "Cart icon is not displayed on Inventory page!");
        Assert.assertTrue(InventoryPage.assertProductItemsCount(), "Incorrect number of product items displayed on Inventory page!");

    }
}
