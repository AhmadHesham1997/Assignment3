package Test;

import Base.BaseTest;
import Pages.P01_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Util.DataDriven;

public class LoginPageTest extends BaseTest {
    //instance of the P01_LoginPage class to use its methods in our test cases
    P01_LoginPage LoginPage;

    @Test(dataProvider = "loginData", dataProviderClass = DataDriven.class)
    public void loginTests(String username, String password, String type) {

        LoginPage = new P01_LoginPage(driver);

        LoginPage.loginTest(username, password);

        switch (type) {

            case "valid":
                Assert.assertTrue(LoginPage.assertSuccessfulLogin(),
                        "Valid login failed!");
                break;

            case "invalid":
                Assert.assertTrue(LoginPage.assertInvalidLogin(),
                        "Invalid login test failed!");
                break;

            case "emptyPassword":
                Assert.assertTrue(LoginPage.assertEmptyPassword(),
                        "Empty password test failed!");
                break;
        }
    }
}


