package com.arshad.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/featurefile",
		glue= {"com.arshad.StepDefinition","com.arshad.CommonStepDefinition"},
		dryRun = false,
		monochrome = true,
		tags="@GetCEOname or @getTimeSheets",   //it will create text fail of failed scenarios //we can store in any location in our project
		plugin= {
				"rerun:target/failed_scenarios.txt"  , 
			//	"html:cucumber_report/WebReport",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				//"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"   //allure reportwill work only if nodejs there
				}, 
		publish=true 
        //by using this we can generate normal cuc.report which we can share
		)

public class TestRunner {
 //pretty plugin = generate better readable report in console
	//usage plugin = generate time for each steps
}
