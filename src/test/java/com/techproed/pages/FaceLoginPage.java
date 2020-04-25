package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {
    //We will create page objects(webelement) in this class
    //We will store all of the face log in page object in this class and use in testss classes

    //creating driver
    WebDriver driver;
    //initialize the driver using constructor
    public FaceLoginPage(WebDriver driver){
        this.driver=driver;
        //We are using PageFactory to initialize the driver
        PageFactory.initElements(driver,this);//driver is page instance, this means page instance
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement signin;





}

