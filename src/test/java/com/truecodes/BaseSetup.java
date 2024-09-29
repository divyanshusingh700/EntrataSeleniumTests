package com.truecodes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseSetup {
    protected WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();//setting up the new chrome driver
        driver.manage().window().maximize();//maximizing the chrome window


    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}