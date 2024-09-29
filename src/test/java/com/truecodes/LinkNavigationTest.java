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
        driver.get("https://www.entrata.com/sign-in");// Open the target webpage

        // Handle cookie acceptance consent if needed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-accept")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent button not found or already accepted.");
        }

        wait.until(ExpectedConditions.urlToBe("https://www.entrata.com/sign-in"));//wait until this webpage is loaded
        String currentUrl = driver.getCurrentUrl();//get current open url
        Assert.assertEquals(currentUrl, "https://www.entrata.com/sign-in", "Sign in page url is incorrect");//check if that url is correct

        WebElement residentLoginLink = driver.findElement(By.linkText("Resident Login"));//find element by link text Resident Login
        residentLoginLink.click();

        //verify current url opened is for resident portal
        wait.until(ExpectedConditions.urlToBe("https://www.residentportal.com/"));
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.residentportal.com/", "Resident login page url is incorrect");
    }
}
