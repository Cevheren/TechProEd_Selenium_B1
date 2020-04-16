package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {

    @Test
    public void login() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        WebElement signin=driver.findElement(By.xpath("//input[@value='Log In']"));
      email.sendKeys("fakeusername");
      password.sendKeys("fakepassword");
      signin.click();
      Thread.sleep(3000);
      WebElement signUp=driver.findElement(By.linkText("Forgot Password?"));
      Assert.assertTrue(signUp.isDisplayed());
    }
}
