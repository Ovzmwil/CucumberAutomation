package com.lsantana.automation.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hook {

	@After
	public void generateReport(Scenario scenario) {
		byte[] screenshot = ((TakesScreenshot) Steps.driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		Steps.driver.quit();
	}

}
