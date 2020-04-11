package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameters(String noOfPassengers, String expectedPrice) {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage() {
        RegistrationPage page = new RegistrationPage(driver);
        page.goTo();
        page.enterUserDetails("Selenium", "Web Driver");
        page.enterUserCredentials("Selenium", "Docker");
        page.onSubmit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage page = new RegistrationConfirmationPage(driver);
        page.goToFlightDetails();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailPage() {
        FlightDetailsPage page = new FlightDetailsPage(driver);
        page.selectPassengers(noOfPassengers);
        page.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailPage")
    public void findFlightPage() {
        FindFlightPage page = new FindFlightPage(driver);
        page.submitFindFlightPage();
        page.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage() {
        FlightConfirmationPage page = new FlightConfirmationPage(driver);
        String actual =  page.getPrice();
        Assert.assertEquals(actual, expectedPrice);
    }

}
