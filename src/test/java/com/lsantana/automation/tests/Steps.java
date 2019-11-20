package com.lsantana.automation.tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.lsantana.automation.enums.Browser;
import com.lsantana.automation.enums.ClassType;
import com.lsantana.automation.pages.FlightConfirmationPage;
import com.lsantana.automation.pages.FlightFinderPage;
import com.lsantana.automation.pages.LoginPage;
import com.lsantana.automation.pages.PurchasePage;
import com.lsantana.automation.pages.SelectFlightPage;
import com.lsantana.automation.utils.Data;
import com.lsantana.automation.utils.SeleniumHelper;
import com.lsantana.automation.utils.WebDriverManager;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Steps {
	
	static WebDriver driver;
	private LoginPage loginPage;
	private FlightFinderPage flightFinderPage;
	private SelectFlightPage selectFlightPage;
	private PurchasePage purchasePage;
	private FlightConfirmationPage flightConfirmationPage;
	private SeleniumHelper seleniumHelper;
	
	public void setUp() {
		driver = WebDriverManager.getDriver(Browser.CHROME);
		loginPage = new LoginPage(driver);
		flightFinderPage = new FlightFinderPage(driver);
		selectFlightPage = new SelectFlightPage(driver);
		purchasePage = new PurchasePage(driver);
		flightConfirmationPage = new FlightConfirmationPage(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	@Given("^access the url: http://www.newtours.demoaut.com/$")
	public void accessUrl() {
		setUp();
		loginPage.accessUrl("http://www.newtours.demoaut.com/");
		seleniumHelper.takeScreenshot("accessUrl");
	}
	
	@And("^enter the username$")
	public void enterUsername(DataTable table) {
		loginPage.setUsername("mercury");
	}
	
	@And("^enter the password$")
	public void enterPassword() {
		loginPage.setPassword("mercury");
	}
	
	@And("^click on the sign in button$")
	public void clickOnSignIn() {
		loginPage.clickOnSignIn();
	}
	
	@And("^select the departing city$")
	public void selectDepartingCity() {
		flightFinderPage.setDepartingFrom("Frankfurt");
	}
	
	@And("^select the arriving city$")
	public void selectArrivingCity() {
		flightFinderPage.setArrivingCity("London");
	}
	
	@And("^select the date$")
	public void selectDate() {
		flightFinderPage.setDepartingDate(Data.getDepartingDate());
		flightFinderPage.setReturningDate(Data.getRandomReturningDate());
	}
	
	@And("^select the class$")
	public void selectClass() {
		flightFinderPage.setClass(ClassType.ECONOMY);
		
	}
	
	@And("^set the passengers number$")
	public void setPassengerNumber() {
		flightFinderPage.setPassengersNumber(1);
	}
	
	@And("^click on Continue button$")
	public void clickOnContinue() {
		flightFinderPage.clickOnContinue();
	}
	
	@And("^select the flight$")
	public void selectTheFlight() {
		selectFlightPage.selectRandomFlight();
		selectFlightPage.selectRandomReturnFlight();
	}
	
	@And("^click on Continue button select flight$")
	public void clickOnContinueButtonSelectFlight() {
		selectFlightPage.clickOnContinue();
	}
	
	@And("^enter first and last name$")
	public void enterFirstAndLastName() {
		purchasePage.setCreditCardFirstAndLastName("Leandro", "Santana");
	}
	
	@And("^enter the card number$")
	public void enterCardNumber() {
		purchasePage.setCreditCardInfo(Data.getRandomCardNumber());
	}
	
	@And("^enter the passenger name$")
	public void enterPassengerName() {
		purchasePage.setPassangerName("Leandro", "Santana");
	}
	
	@And("^click on the Secure Purchase$")
	public void clickOnSecurePurchase() {
		purchasePage.clickOnSecurePurchase();
	}
	
	@Then("^the order is generated$")
	public void orderIsGenerated() {
		assertEquals(true, flightConfirmationPage.confirmationIsPresent());
	}
}
