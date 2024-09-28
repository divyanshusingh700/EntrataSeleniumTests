package com.truecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseSetup{
    @Test
    public void verifyContactForm(){
        driver.get("https://www.entrata.com");
        driver.findElement(By.id("contact-us")).click();//open contact form modal by clicking contact us button
        Assert.assertTrue(driver.findElement(By.id("name")).isDisplayed());//Assert the form modal has opened by checking visibility of name field
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());//Assert the form modal has opened by checking visibility of email field
    }
}
