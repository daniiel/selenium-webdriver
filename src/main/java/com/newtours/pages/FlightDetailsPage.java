package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passengersSelect;

    @FindBy(name = "fromPort")
    private WebElement departingFromSelect;

    @FindBy(name = "fromMonth")
    private WebElement onFromMonthSelect;

    @FindBy(name = "fromDay")
    private WebElement onFromDaySelect;

    @FindBy(name = "toPort")
    private WebElement arrivingInSelect;

    @FindBy(name = "toMonth")
    private WebElement toMonthSelect;

    @FindBy(name = "findFlights")
    private WebElement submitBtn;


    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectPassengers(String noOfPassengers) {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengersSelect));
        Select select = new Select(passengersSelect);
        select.selectByValue(noOfPassengers);
    }

    public void goToFindFlightsPage() {
        this.submitBtn.click();
    }

}
