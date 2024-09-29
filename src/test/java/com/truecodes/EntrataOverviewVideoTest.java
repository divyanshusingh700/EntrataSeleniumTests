package com.truecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EntrataOverviewVideoTest extends BaseSetup{
    @Test
    public void verifyVideoIframeVisibility() throws InterruptedException{
        driver.get("https://www.entrata.com/a#");// Open the target webpage

        // Handle cookie acceptance consent if needed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-accept")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent button not found or already accepted.");
        }

        // Locate the overview video button link and click it using standard WebElement click method
        WebElement videoButton = driver.findElement(By.cssSelector(".hero-play-button"));
        videoButton.click();

        // Locate the iframe box and verify if it's visible
        WebElement iFrameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.embedly-embed")));
        Assert.assertTrue(iFrameBox.isDisplayed(),"The iframe box should be visible after clicking the video button");
    }
}
