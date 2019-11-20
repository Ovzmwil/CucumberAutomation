package com.lsantana.automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lsantana.automation.enums.Browser;

public class WebDriverManager {
	
	private static WebDriver driver;
	private final static int implicityWait = 30;
	
	public static WebDriver getDriver(Browser browser) {
		if (driver == null)
			driver = createDriver(browser);
		return driver;
	}
	
	private static WebDriver createDriver(Browser browser) {
		switch(browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Driver not defined.");
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(implicityWait, TimeUnit.SECONDS);
		return driver;
	}

}
