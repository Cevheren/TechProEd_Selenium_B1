package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage1;
import com.techproed.pages.FHCReservationPage;
import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCReservationTest {
FHCReservationPage fhcReservationPage=new FHCReservationPage();
FHCLoginPage1 fhcLoginPage1=new FHCLoginPage1();
    @Test
    public void RegistrationTest(){
        Driver.getDriver().get(ConfigReader.getProperty("fhc_registration_url"));

        fhcLoginPage1.login("manager2","Man1ager2!");

        //You are on the registration page
        //Fill out all required fields and create a reservation
        Select iduserSelect=new Select(fhcReservationPage.idUserSelectUser);
        iduserSelect.selectByIndex(1);

        //selecting iduser
        Select iduserSelect2=new Select(fhcReservationPage.idUserSelectRoom);
        iduserSelect2.selectByIndex(2);

        //entering the price
        fhcReservationPage.price.sendKeys("500");

        //enter start date
        fhcReservationPage.dateStart.sendKeys("04/24/2020");

        //enter end date
        fhcReservationPage.dateEnd.sendKeys("04/25/2020");

        //entering adult amount
        fhcReservationPage.adultAmount.sendKeys("2");

        //children amount
        fhcReservationPage.childrenAmount.sendKeys("4");

        //contact name and surname
        fhcReservationPage.surname.sendKeys("Ahmet B");

        //entering phone number
        fhcReservationPage.phone.sendKeys("(999) 999-9999");

        //entering contact email
        fhcReservationPage.email.sendKeys("test@fakeemail.com");

        //Notes:
        fhcReservationPage.notes.sendKeys("I want sea view only");

        //clinking on the approved checkbox
        fhcReservationPage.isApproved.click();

        //clinking on the is paid checkbox
        fhcReservationPage.isPaid.click();

        fhcReservationPage.submitButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String message=fhcReservationPage.success_message.getText();

        Assert.assertTrue(message.equals("RoomReservation was inserted successfully"));

    }
}
