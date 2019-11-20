package com.lsantana.automation.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/FirstScenario.feature", glue = { "com.lsantana.automation.tests" }, plugin = {
		"pretty", "html:target/cucumber", "json:target/cucumber.json"}, monochrome = true, dryRun = false)
public class Runner {
	
}


