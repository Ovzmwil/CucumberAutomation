package com.lsantana.automation.utils;

import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class SeleniumHelper {
	
	WebDriver driver;
	
	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void takeScreenshot(String fileName) {
		try {
			Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE_CHROME, 100, true).withName(fileName)
			.save(System.getProperty("user.dir") + "\\target\\cucumber");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
