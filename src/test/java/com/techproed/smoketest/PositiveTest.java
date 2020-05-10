package com.techproed.smoketest;

import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;


public class PositiveTest extends TestBase {

    @Test
    public void positiveLoginTest(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FhcLoginPage fhcLoginPage=new FhcLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.login.click();
    }
}
