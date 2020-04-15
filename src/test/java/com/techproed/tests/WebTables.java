package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

//        Create a class: WebTables
public class WebTables extends TestBase {

//        Create a method: login() and log in : http://www.fhctrip.com/admin/HotelRoomAdmin
    public void login(){
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");;
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

//        Finding size of the entire table body
    @Test
    public void entireTable() throws InterruptedException {
     login();//loging in using the login method.


//        Print the element of a 15th cell
        Thread.sleep(3000);
        WebElement tBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());
        //Finding the size=>find the total number of cells in the table bodyu
        List<WebElement> table=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("The size of the table body is ===>> "+table.size());//Size of the table
        System.out.println(driver.findElements(By.tagName("//tbody//td")).size());//We can use tag name to find the data
        List<WebElement> allHeader=driver.findElements(By.tagName("th"));
        for (WebElement header:allHeader){
            System.out.println(header.getText());
        }

    }

    //        Find the total number of rows and cells in the table body
    @Test
    public void printRows(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tbody//tr")).size()+" rows in the table body");
        //print the rows
        List<WebElement> allRows=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row:allRows){
            System.out.println(row.getText());
        }

        //        Print the elements of 4th row
        List<WebElement> elements4th=driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement element :elements4th){
            System.out.println(element.getText());
        }

    }

    //        Find the total number of cells in the table body
    @Test
    public void printCells(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tbody//td")).size()+" cells in the table body");
        List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement cell:allCells){
            System.out.println(cell.getText());
        }
    }

    @Test
    public void printColumn(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tr[3]//td")).size()+" column in the table body");
        //        Print the elements of the 5th column
        List<WebElement> columns5th=driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement element:columns5th){
            System.out.println(element.getText());
        }

    }







}
