package com.lsantana.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	
	private WebDriverWait wait;
	
	public FlightConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(how = How.XPATH, using = "//*[normalize-space()='Your itinerary has been booked!']")
	WebElement confirmation;
	
	public boolean confirmationIsPresent() {
		wait.until(ExpectedConditions.visibilityOf(confirmation));
		return true;
	}

}
