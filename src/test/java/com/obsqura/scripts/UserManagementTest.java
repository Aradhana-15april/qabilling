package com.obsqura.scripts;

import Base.TestHelper;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagement;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.GenericUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagementTest extends TestHelper {

    LoginPage login;
    UserManagement usermanagement;
    ExcelUtility excelutility = new ExcelUtility();

    @Test
    public void verifyNewUserCreation() throws InterruptedException {
        LoginPage loginpge = new LoginPage(driver);
        usermanagement = new UserManagement(driver);

        loginpge.loginUser("admin", "123456");
        usermanagement.endTour();
        excelutility.setExcelFile("usermanagement", "usersdata");
        usermanagement.clickOnUserManagmentPage();
        Thread.sleep(4000);
        usermanagement.clickOnUser();
        Thread.sleep(4000);
        usermanagement.clickOnAdd();
        Thread.sleep(4000);
        String role="engineer";
        String prefix = excelutility.getCellData(0, 0);
        String firstName = excelutility.getCellData(0, 1);
        String lastName = excelutility.getCellData(0, 2);
        String email = excelutility.getCellData(0, 3);
        email=email+ GenericUtility.getRandomNumber()+"@gmail.com";
        String userName = excelutility.getCellData(0, 4);
        String password = excelutility.getCellData(0, 5);
        String confirmPassword = excelutility.getCellData(0, 6);
        String salesCommissionPercentage = excelutility.getCellData(0, 7);
        usermanagement.createUser(prefix, firstName, lastName, email, userName, password, confirmPassword, salesCommissionPercentage,role);
        String expectedAlertMessage = "user added successfully";
       // Assert.assertEquals(usermanagement.getUserCreationMessage(), expectedAlertMessage);
        //Assert.assertEquals(usermanagement.alertMessageUserAdd(),expectedAlertMessage);
        String actualMessage=usermanagement.alertMessageUserAdd();
        Assert.assertEquals(actualMessage,"user added successfully");

    }

}





