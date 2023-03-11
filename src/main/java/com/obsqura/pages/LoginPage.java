package com.obsqura.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "username")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(name = "remember")
    WebElement remember;
    @FindBy(xpath = "//button[contains(@type,'submit')]")
    WebElement login;
    @FindBy(xpath = "//span[@class='help-block']")
    public WebElement invalidcredentialmessage;
    @FindBy(xpath = "//*[contains(text(),'Welcome vishwanadhan,')]")
    WebElement actualTitle;
    @FindBy(xpath = "//span[text()='vishwanadhan Aanadh']")
    WebElement profile;
    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement signoutelement;

    public LoginPage(WebDriver driver) {

        this.driver = driver;//when object is created then this driver is receive
        PageFactory.initElements(driver, this);//driver.findElements
    }

    public void loginUser(String username1, String password1) {
        username.sendKeys(username1);
        password.sendKeys(password1);
        remember.click();
        login.click();

    }

    public String getLoginPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public void signOut() {
        profile.click();
        signoutelement.click();
    }
}









