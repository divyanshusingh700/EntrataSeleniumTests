package com.truecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinkNavigationTest extends BaseSetup{
    @Test
    public void verifySignInAndResidentLoginLinks(){
        driver.get("https://www.entrata.com/sign-in");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-accept")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent button not found or already accepted.");
        }

        WebElement residentLoginLink = driver.findElement(By.linkText("Resident Login"));
        residentLoginLink.click();

        wait.until(ExpectedConditions.urlToBe("https://www.residentportal.com/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.residentportal.com/", "Resident login page url is incorrect");
    }
}
