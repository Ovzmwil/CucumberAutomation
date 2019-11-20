package com.lsantana.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(how = How.NAME, using = "userName")
	WebElement txtUsername;
	
	@FindBy(how = How.NAME, using = "password")
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "login")
	WebElement btnSignIn;
	
	public void setUsername(String username) {
		wait.until(ExpectedConditions.elementToBeClickable(txtUsername));
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(txtPassword));
		txtPassword.sendKeys(password);
	}
	
	public void clickOnSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
		btnSignIn.click();
	}
	
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickOnSignIn();
	}
	
	public void accessUrl(String url) {
		driver.navigate().to(url);
	}
	

}
