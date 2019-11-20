package com.lsantana.automation.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightPage {
	
	private WebDriverWait wait;
	private Random random = new Random();
	
	public SelectFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(how = How.NAME, using = "outFlight")
	List<WebElement> flightList;
	
	@FindBy(how = How.NAME, using = "inFlight")
	List<WebElement> returnFlightList;
	
	@FindBy(how = How.NAME, using = "reserveFlights")
	WebElement btnContinue;
	
	public void selectRandomFlight() {
		if(flightList.get(0) != null) {
			flightList.get(random.nextInt(flightList.size()-1)).click();
		}
	}
	
	public void selectRandomReturnFlight() {
		if(returnFlightList.get(0) != null) {
			returnFlightList.get(random.nextInt(returnFlightList.size()-1)).click();
		}
	}
	
	public void clickOnContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
		btnContinue.click();
	}

}
