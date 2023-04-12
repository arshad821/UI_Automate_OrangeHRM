package com.arshad.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//to re run failed scenarios 
@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/failed_scenarios.txt", 
		glue= {"com.arshad.StepDefinition","com.arshad.CommonStepDefinition"},
		dryRun = false,
		monochrome = true,
		tags="@GetHRManager or @getTimeSheets"

		)

public class Rerunner {

}
