package com.lsantana.automation.pages;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lsantana.automation.enums.ClassType;

public class FlightFinderPage {
	
	private WebDriverWait wait;
	private Select select;
	
	public FlightFinderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@value='roundtrip']")
	WebElement radioRoundTrip;
	
	@FindBy(how = How.XPATH, using = "//*[@value='oneway']")
	WebElement radioOneWay;
	
	@FindBy(how = How.NAME, using = "passCount")
	WebElement cboPassCount;
	
	@FindBy(how = How.NAME, using = "fromPort")
	WebElement cboDepartingCity;
	
	@FindBy(how = How.NAME, using = "fromMonth")
	WebElement cboDepartingMonth;
	
	@FindBy(how = How.NAME, using = "fromDay")
	WebElement cboDepartingDay;
	
	@FindBy(how = How.NAME, using = "toPort")
	WebElement cboArrivingCity;
	
	@FindBy(how = How.NAME, using = "toMonth")
	WebElement cboReturningMonth;
	
	@FindBy(how = How.NAME, using = "toDay")
	WebElement cboReturningDay;
	
	@FindBy(how = How.XPATH, using = "//*[@value='Coach']")
	WebElement chkEconomyClass;
	
	@FindBy(how = How.XPATH, using = "//*[@value='Business']")
	WebElement chkBusinessClass;
	
	@FindBy(how = How.XPATH, using = "//*[@value='First']")
	WebElement chkFirstClass;
	
	@FindBy(how = How.NAME, using = "airline")
	WebElement cboAirline;
	
	@FindBy(how = How.NAME, using = "findFlights")
	WebElement btnContinue;
	
	public void clickOnRoundTrip() {
		wait.until(ExpectedConditions.elementToBeClickable(radioRoundTrip));
		radioRoundTrip.click();
	}
	
	public void clickOnOneWay() {
		wait.until(ExpectedConditions.elementToBeClickable(radioOneWay));
		radioOneWay.click();
	}
	
	public void setPassengersNumber(int passengersNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(cboPassCount));
		select = new Select(cboPassCount);
		select.selectByVisibleText(String.valueOf(passengersNumber));
	}
	
	public void setDepartingFrom(String departingCity) {
		wait.until(ExpectedConditions.elementToBeClickable(cboDepartingCity));
		select = new Select(cboDepartingCity);
		select.selectByVisibleText(departingCity);
	}
	
	public void setArrivingCity(String arrivingCity) {
		wait.until(ExpectedConditions.elementToBeClickable(cboArrivingCity));
		select = new Select(cboArrivingCity);
		select.selectByVisibleText(arrivingCity);
	}
	
	public void setDepartingDate(LocalDate localDate) {
		wait.until(ExpectedConditions.elementToBeClickable(cboDepartingMonth));
		select = new Select(cboDepartingMonth);
		select.selectByIndex(localDate.getMonthValue()-1);
		
		select = new Select(cboDepartingDay);
		select.selectByIndex(localDate.getDayOfMonth()-1);
	}
	
	public void setReturningDate(LocalDate localDate) {
		wait.until(ExpectedConditions.elementToBeClickable(cboReturningMonth));
		select = new Select(cboReturningMonth);
		select.selectByIndex(localDate.getMonthValue()-1);
		
		select = new Select(cboReturningDay);
		select.selectByIndex(localDate.getDayOfMonth()-1);
	}
	
	public void setClass(ClassType classType) {
		switch(classType) {
		case ECONOMY:
			chkEconomyClass.click();
			break;
		case BUSINESS:
			chkBusinessClass.click();
			break;
		case FIRST:
			chkFirstClass.click();
		}
	}
	
	public void setClass(String classType) {
		if (classType.contains("Economy")) {
			chkEconomyClass.click();
		} else if (classType.contains("Business")) {
			chkBusinessClass.click();
		} else {
			chkFirstClass.click();
		}
	}
	
	public void setAirline(String airline) {
		wait.until(ExpectedConditions.elementToBeClickable(cboAirline));
		select = new Select(cboAirline);
		select.selectByVisibleText(airline);
	}
	
	public void clickOnContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
		btnContinue.click();
	}

}
