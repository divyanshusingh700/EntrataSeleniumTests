package com.truecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CareersPageTest extends BaseSetup{
    @Test
    public void navigateToCareersPage(){
        driver.get("https://www.entrata.com");// Open the target webpage

        // Handle cookie acceptance consent if needed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-accept")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent button not found or already accepted.");
        }

        driver.findElement(By.linkText("Careers")).click();//click on the careers link in the footer
        Assert.assertTrue(driver.getCurrentUrl().contains("/careers"));//Assert the url contains careers section
    }
}
