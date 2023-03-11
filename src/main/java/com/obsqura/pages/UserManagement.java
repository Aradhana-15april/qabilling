package com.obsqura.pages;

import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagement {
    WebDriver driver;
    WaitUtility waitutility;
    GenericUtility genericutility;



    @FindBy(xpath = "//input[@id='surname']")
    WebElement prefixelement;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstnameelement;
    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastnameelement;
     @FindBy(xpath = "//input[@id='email']")
     WebElement emailelement;
    // @FindBy(xpath = '//span[@id=\'select2-role-container\']')
     //WebElement roles;
     @FindBy(name = "username")
     WebElement usernameelement;
     @FindBy(name = "password")
     WebElement passwordelement;
     @FindBy(name="confirm_password")
     WebElement confirmpasswordelement;
    @FindBy(name ="cmmsn_percent" )
     WebElement commissionelement;
    @FindBy(xpath="//button[@id='submit_user_button']")
    WebElement saveelement;
    @FindBy(xpath="//span[text()='User Management']")
    WebElement usermanagementelement;
    @FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users']")
    WebElement userselement;
    @FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users/create']")
    WebElement addelement;
    @FindBy(xpath="//input[@id='status_span']")
    WebElement successmessage;
    @FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/roles']")
    WebElement roleselement;
    @FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/roles/create']")
    WebElement addrolesbuttonelement;
    @FindBy(xpath = "//input[@id='name']")
    WebElement nameelement;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endtourelement;
    @FindBy(xpath = "//input[@id='status_span' and @data-msg='User added successfully']")
            WebElement messageelement;
    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
    WebElement roleselement1;
    @FindBy(id="select2-role-container")
    WebElement clickrole;








    public UserManagement(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String alertMessageUserAdd(){
        String message=messageelement.getText();
        return message;
    }
    public void selectRole(String role)
    {
        clickrole.click();
        roleselement1.sendKeys(role+ Keys.ENTER);
        //driver.findElement(By.xpath("//li[text()='tailor']")).click();


    }
    public void endTour(){
        endtourelement.click();
    }
    public void setPrefix(String prefix) {
        prefixelement.sendKeys(prefix);

    }

    public void setFirstname(String firstname) {
        firstnameelement.sendKeys(firstname);
    }

    public void setLastname(String lastname) {
        lastnameelement.sendKeys(lastname);
    }

    public void setEmail(String email) {
        emailelement.sendKeys(email);
    }

    //public void setRoles(String roles) {
        //roleselement.sendKeys(roles);

   // }

    public void setUsername(String username) {
        usernameelement.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordelement.sendKeys(password);
    }

    public void setConfirmpassword(String confirmpassword) {
        confirmpasswordelement.sendKeys(confirmpassword);
    }

    public void setCommission(String commission) {
        commissionelement.sendKeys(commission);

    }

    public void setSave(String save) {
        saveelement.click();


    }
    public void clickOnUserManagmentPage()
    {
        usermanagementelement.click();


    }
    public void clickOnUser()
    {
        userselement.click();

    }
    public void clickOnAdd()
    {
        addelement.click();
    }


    public void createUser(String prefix, String firstName, String lastName, String email, String userName, String password, String confirmPassword, String salesCommissionPercentage,String role)
    {
        WaitUtility wait=new WaitUtility(driver);
        waitutility.waitForVisibility(prefixelement);
     setPrefix(prefix);
     setFirstname(firstName);
     setLastname(lastName);
     setEmail(email);
     setUsername(userName);
     setPassword(password);
     setConfirmpassword(confirmPassword);
     setCommission(salesCommissionPercentage);
     saveelement.click();
     selectRole(role);

    }
    public String getUserCreationMessage()
    {
        return successmessage.getAttribute("data-msg");

    }
    public boolean isAlertMessageDisplayed(String expectedMessage)
    {
        genericutility = new GenericUtility();
        return genericutility.is_TextAsExpected(successmessage, expectedMessage);
    }


       public void clickOnRole()
       {

         roleselement.click();
       }
       public void clickOnRolesAddButton(){
           addrolesbuttonelement.click();
       }


}



