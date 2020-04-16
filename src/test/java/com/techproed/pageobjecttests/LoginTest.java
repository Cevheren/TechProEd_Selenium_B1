package com.techproed.pageobjecttests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void firstPageObjectTest(){
        driver.get("https://www.facebook.com/");
        FaceLoginPage faceLoginPage=new FaceLoginPage(driver);
        faceLoginPage.email.sendKeys("username");
        faceLoginPage.password.sendKeys("password");
        faceLoginPage.signin.click();
    }

}
