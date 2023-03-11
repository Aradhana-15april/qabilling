package com.obsqura.scripts;

import Base.TestHelper;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest  extends TestHelper {
    LoginPage login;
    HomePage homepage=new HomePage(driver);

    @Test
    public void homePageQaLegend() {
        HomePage home = new HomePage(driver);
        ExcelUtility test = new ExcelUtility();
        test.setExcelFile("logindata", "validcredentials");
        test.getCellData(0, 0);
        System.out.println(test.getCellData(0, 0));

    }
    @Test(priority = 1, groups={"regression","smoke"})
    public void checkHomePageLoaded()
    {
        LoginPage login = new LoginPage(driver);
        login.loginUser("admin", "123456");
        HomePage homepage=new HomePage(driver);
        homepage.isHomePageLoaded();

        Assert.assertTrue(homepage.isHomePageLoaded(), "Home page not loaded");
    }
    @Test(priority = 2)
    public void profileTitleTest()
    {
        String expectedtitle="Home - las";
        String actualtitle=driver.getTitle();
        Assert.assertEquals(actualtitle, expectedtitle);
        System.out.println("After hard assertion "+" Title is same");
    }


}

