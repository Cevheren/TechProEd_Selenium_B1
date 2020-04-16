package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //What is abstract class?=>
    //Where did you use abstract in your framework?=>I use abstract in my TestBase class
    //I have TestBase in my framework, that is an abstract class
    //The purpose of that is not to create an object, but just to use its method


    //We use TestBase for repeated actions such as setting up driver
    //creating the driver, maximizing window.
    //We also have wait in the TestBase Class
    //We have tearDown method to close the browser after we are done with the test
    protected WebDriver driver;
    protected Actions actions;//Make sure to create this in the class level
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        actions=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Implicit wait is global wait
        //When we use this in TestBase, we don't need to use it in Test Classes again

    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
