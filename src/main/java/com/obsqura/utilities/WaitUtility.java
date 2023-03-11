package com.obsqura.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    WebDriver driver;

    public  WaitUtility(WebDriver driver)
    {
        this.driver=driver;
    }
    public void waitForVisibility(String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }
    public void waitForVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

}






