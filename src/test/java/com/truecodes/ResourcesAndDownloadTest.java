package com.truecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class ResourcesAndDownloadTest extends BaseSetup{
    @Test
    public void verifyResourcesAndDownloadLink(){
        // Open the target webpage
        driver.get("https://www.entrata.com/");

        // Handle cookie acceptance consent if needed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-accept")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent button not found or already accepted.");
        }

        // Locate the "See all Resources" link and click it using standard WebElement click method
        WebElement seeAllResourcesLink = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[12]/div[1]/a[1]"));
        seeAllResourcesLink.click();

        wait.until(ExpectedConditions.urlToBe("https://www.entrata.com/resources"));// Wait for the resources page to load and verify the URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.entrata.com/resources", "Resources page URL is incorrect.");

        // Locate the "Download Now" button and click it (this opens a new tab)
        WebElement downloadNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'https://go.entrata.com/generative-ai-101-ebook.html') and contains(@class, 'button hover_black')]")));
        downloadNowButton.click();

        String originalWindow = driver.getWindowHandle();// Store the current window handle (original tab)

        waitForNewTabAndSwitch();// Wait for the new tab to open and switch to it

        wait.until(ExpectedConditions.urlToBe("https://go.entrata.com/generative-ai-101-ebook.html"));// Verify the new tab's URL
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://go.entrata.com/generative-ai-101-ebook.html", "Download page URL is incorrect.");

        // Close the new tab and switch back to the original window
        driver.close();
        driver.switchTo().window(originalWindow);

    }
    // Helper method to switch to the new tab
    private void waitForNewTabAndSwitch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

}
