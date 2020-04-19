package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbRegisterPage {
    //driver====>>>>Driver.getDriver()
    public GlbRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        //This is needed to initiate the page specific objects
    }
    @FindBy(id="email")
    public WebElement email;
    @FindBy(xpath="//input[@name='name']")
    public WebElement name;
    @FindBy(xpath = "//input[@name='mobile']")
    public WebElement phoneNumber;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy (xpath = "//input[@name='re_password']")
    public WebElement repassword;
    @FindBy (xpath= "//button[@value='Login']")
    public WebElement signUp;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement message;

}
