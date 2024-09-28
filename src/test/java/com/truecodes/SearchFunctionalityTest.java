package com.truecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFunctionalityTest extends BaseSetup{
    @Test
    public void testSearchFunction(){
        driver.get("https://www.entrata.com");
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("software"+ Keys.ENTER);//find the search input and type software and press enter
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("software"));//Assert the search results page contains expected results

    }
}
