package com.obsqura.scripts;

import Base.TestHelper;
import com.obsqura.constants.ErrorMessages;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.ScreenshotUtility;
import com.obsqura.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestHelper {
    LoginPage login;
    WebDriver driver;
    WaitUtility wait;
    PageUtility pageutility;

    @Test(priority = 1, description = "TC001 Verify Valid QaLegendLogin", groups = {"Regression"})
    public void TC001_verifyValidQaLegendLogin() {

        LoginPage loginpge = new LoginPage(driver);

        login.loginUser("admin", "123456");

    }

    @Test(priority = 1, enabled = true, groups = {"Smoke"})
    public void invalidUserNameLogin() {
        driver.navigate().refresh();
        login = new LoginPage(driver);
        login.loginUser("admi", "123456");
        String actual = login.invalidcredentialmessage.getText();
        String expected = "These credentials do not match our records.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2, description = "TC002 Verify Login Page Title", groups = {"Sanity"})
    public void TC002_verifyLoginPageTitle() {
        LoginPage login = new LoginPage(driver);
        ExcelUtility test = new ExcelUtility();
        test.setExcelFile("logindata", "titleverification");
        test.getCellData(0, 0);
        System.out.println(test.getCellData(0, 0));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login - Demo POS";
        Assert.assertEquals(actualTitle, expectedTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);

        ScreenshotUtility screenshot = new ScreenshotUtility();
        screenshot.takeScreenshot(driver, "LoginTest");

    }

    @Test(priority = 3, enabled = true, groups = {"Smoke"})
    public void invalidUserNameAndPasswordLogin() {
        pageutility = new PageUtility();
        driver.navigate().refresh();
        login.loginUser("admi", "12345");
        String actual = login.invalidcredentialmessage.getText();
        String expected = "These credentials do not match our records.";
        Assert.assertEquals(actual, expected);


    }

    @Test(priority = 2, enabled = true, groups = {"Smoke"})
    public void invalidpasswordLogin() {
        pageutility = new PageUtility();
        driver.navigate().refresh();
        login.loginUser("admin", "12345");
        String actual = login.invalidcredentialmessage.getText();
        String expected = "These credentials do not match our records.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 3, enabled = true, groups = {"Smoke"})

    public void checkSignOut() {
        login.signOut();
        String actual = driver.getTitle();
        String expected = "Login - Demo POS";
        Assert.assertEquals(actual, expected);
        System.out.println("Logout successfull");


    }

}
