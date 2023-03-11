package com.obsqura.utilities;

import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenericUtility {
    public static String getRandomNumber()
    {
        Random random=new Random(3);
        int number= random.nextInt();
        return String.valueOf(number);

    }
    public static String getTimeStamp()
    {
        String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
        return timeStamp;
    }
    public String getTextOfElement(WebElement element) {
        return element.getText();
    }
    public boolean is_TextAsExpected(WebElement element, String expectedtext)
    {
        String text = element.getText();
        return text.equals(expectedtext);
    }
}
