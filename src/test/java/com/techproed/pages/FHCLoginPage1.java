package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FHCLoginPage1 {
    //create a login page with objects and log in method
    public FHCLoginPage1(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //page objects
    @FindBy(id = "UserName")
    public WebElement username;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement logInButton;
    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement error_message;

    //creating a log in method
    public void login(String user,String pass){
        //login("manager2","Manager2!");==> user=manager2,pass=Manager2!
        //login("asdga","asdga");==>user="asdga" , pass="asdga"
        username.sendKeys(user);
        password.sendKeys(pass);
        logInButton.click();

    }

}
