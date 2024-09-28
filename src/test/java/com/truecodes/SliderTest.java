package com.truecodes;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends BaseSetup{
    @Test
    public void testSliderFunction(){
        driver.get("https://www.entrata.com");
        driver.findElement(By.cssSelector(".slider-next")).click();//locate the next button for slider and click it
        String activeSlide = driver.findElement(By.cssSelector(".slider-active img")).getAttribute("src");//locate the next button for slider and click it
        Assert.assertTrue(activeSlide.contains("expected-image-name"));//Assert the slider has been moved by checking the new image
    }
}
