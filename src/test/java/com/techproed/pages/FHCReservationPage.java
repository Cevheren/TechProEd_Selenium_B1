package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FHCReservationPage {

    public FHCReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "IDUser")
    public WebElement idUserSelectUser;
    @FindBy(id = "IDHotelRoom")
    public WebElement idUserSelectRoom;
    @FindBy(id = "Price")
    public WebElement price;
    @FindBy(id = "DateStart")
    public WebElement dateStart;
    @FindBy(id = "DateEnd")
    public WebElement dateEnd;
    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;
    @FindBy(id = "ChildrenAmount")
    public WebElement childrenAmount;
    @FindBy(id = "ContactNameSurname")
    public WebElement surname;
    @FindBy(id = "ContactPhone")
    public WebElement phone;
    @FindBy(id = "ContactEmail")
    public WebElement email;
    @FindBy(id = "Notes")
    public WebElement notes;
    @FindBy(id = "Approved")
    public WebElement isApproved;
    @FindBy(id = "IsPaid")
    public WebElement isPaid;
    @FindBy(id = "btnSubmit")
    public WebElement submitButton;
    @FindBy(className = "bootbox-body")
    public WebElement success_message;
    @FindBy(xpath = "//*[@data-bb-handler='ok']")
    public WebElement okButton;

}
