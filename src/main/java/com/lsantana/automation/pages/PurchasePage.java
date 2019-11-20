package com.lsantana.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchasePage {
	
	private WebDriverWait wait;
	
	public PurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(how = How.NAME, using = "passFirst0")
	WebElement txtPassangerFirstName;
	
	@FindBy(how = How.NAME, using = "passLast0")
	WebElement txtPassangerLastName;
	
	@FindBy(how = How.NAME, using = "creditCard")
	WebElement cboCardType;
	
	@FindBy(how = How.NAME, using = "creditnumber")
	WebElement txtCardNumber;
	
	@FindBy(how = How.NAME, using = "cc_frst_name")
	WebElement txtCardFirstName;
	
	@FindBy(how = How.NAME, using = "cc_mid_name")
	WebElement txtCardMidleName;
	
	@FindBy(how = How.NAME, using = "cc_last_name")
	WebElement txtCardLastName;
	
	@FindBy(how = How.NAME, using = "buyFlights")
	WebElement btnSecurePurchase;
	
	public void setPassangerName(String firstName, String lastName) {
		wait.until(ExpectedConditions.elementToBeClickable(txtPassangerFirstName));
		txtPassangerFirstName.sendKeys(firstName);
		txtPassangerLastName.sendKeys(lastName);
	}
	
	public void setCreditCardInfo(String cardNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(txtCardNumber));
		txtCardNumber.sendKeys(cardNumber);
	}
	
	public void setCreditCardFirstAndLastName(String firstName, String lastName) {
		wait.until(ExpectedConditions.elementToBeClickable(txtCardFirstName));
		txtCardFirstName.sendKeys(firstName);
		txtCardLastName.sendKeys(lastName);
	}
	
	public void clickOnSecurePurchase() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSecurePurchase));
		btnSecurePurchase.click();
	}
}
