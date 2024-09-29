package com.truecodes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseSetup{
    @Test
    public void verifyHomePageTitle(){
        driver.get("https://www.entrata.com");// Open the target webpage

        String pageTitle = driver.getTitle();// getting the title for entrata home page

        Assert.assertEquals(pageTitle, "Property Management Software | Entrata");//verify that the page title is as expected
    }
}
