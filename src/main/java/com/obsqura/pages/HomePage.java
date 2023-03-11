package com.obsqura.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage {
    WebDriver driver;
    HomePage homepage = new HomePage(driver);

    @FindBy(xpath = "//section[contains(@class,'content-header')]/h1")
    public WebElement welcomenote;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean homePage() {
        String name = welcomenote.getText();
        System.out.println(name);
        return false;
    }
    public boolean isHomePageLoaded(){
        homepage = new HomePage(driver);
        boolean status = homepage.homePage();
        return status;
    }

    @Test(priority = 7)
    public void welcomeNoteTest() {
        homepage = new HomePage(driver);
        boolean status = homepage.welcomenote.isDisplayed();
        if (status) {
            Assert.assertTrue(true);

        } else {
            Assert.assertTrue(false);
        }
    }
}





