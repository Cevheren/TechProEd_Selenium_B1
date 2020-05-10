package com.techproed.tests;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBaseFinal;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class JavaScriptExample {

    @Test
    public void JSTest() throws InterruptedException {
        //casting driver into JS executor
        Driver.getDriver().get("http://www.fhctrip.com/Account/Logon");
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
       WebElement loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
      // flash(loginButton,Driver.getDriver());

        clickElementByJS(loginButton,Driver.getDriver());

        System.out.println(getTitleByJS(Driver.getDriver()));

       drawBorder(loginButton,Driver.getDriver());

      // generateAlert(Driver.getDriver(),"Check the bug in the login button");
        //When tehre is an alert you have to accept ot dismiss to continue

        System.out.println(getPageTexts(Driver.getDriver()));
      // takeScreenShot();


        //scrollDownByJS(Driver.getDriver());


        WebElement viewElement= Driver.getDriver().findElement(By.xpath("//*[.='Instagram']"));
        scrollIntoViewByJS(viewElement,Driver.getDriver());
    }

    //How to find element with JS Executor
    //JS executor will find the the element inside the HTML codedirectly
    //very powerfull //click on any element on the element on the HTML code
    public void clickElementByJS(WebElement element, WebDriver driver){
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].click();",element);
    }

    public String getTitleByJS(WebDriver driver){
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
        String title = javascriptExecutor.executeScript("return document.title;").toString();
        return title;
    }

    public String getPageTexts(WebDriver driver){
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
        String pageText=javascriptExecutor.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    //this will scroll down form to top to buttom
    public void scrollDownByJS(WebDriver driver){
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
        //start from 0. no need to learn the systax. just know there are these cool features
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    //scrolling down until certain element
    //this will keep scroll untill that element is visible
    public void scrollIntoViewByJS(WebElement element,WebDriver driver){
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    //highlightinng the login button for some reason, maybe to emphisie there is a bug
    public void flash(WebElement element, WebDriver driver){
        String bgColor=element.getCssValue("backgroundcolor");
        for (int i=0;i<10;i++){
            changeColor("rgb(0,200,0",element);
            changeColor(bgColor,element);
        }
    }

    public void changeColor(String color, WebElement element){
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '"+color+ "'",element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //drawing a border
    public void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.border = '3px solid red'",element);

    }

    public void takeScreenShot(){
        File file = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("./test-output/image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void generateAlert(WebDriver driver,String message) throws InterruptedException {
        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("alert('"+message+"')");
        Thread.sleep(3000);
    }


    //we can refresh teh browser

}
