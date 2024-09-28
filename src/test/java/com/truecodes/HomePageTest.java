package com.truecodes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseSetup{
    @Test
    public void verifyHomePageTitle(){
        driver.get("https://www.entrata.com");
        String pageTitle = driver.getTitle();// getting the title for entrata home page
        Assert.assertEquals(pageTitle, "Entrata | Property Management Software");//verify that the page title is as expected
    }
}
