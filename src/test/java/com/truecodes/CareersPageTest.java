package com.truecodes;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareersPageTest extends BaseSetup{
    @Test
    public void navigateToCareersPage(){
        driver.get("https://www.entrata.com");
        driver.findElement(By.linkText("careers")).click();//click on the careers link in the footer
        Assert.assertTrue(driver.getCurrentUrl().contains("/careers"));//Assert the url contains careers section
    }
}
