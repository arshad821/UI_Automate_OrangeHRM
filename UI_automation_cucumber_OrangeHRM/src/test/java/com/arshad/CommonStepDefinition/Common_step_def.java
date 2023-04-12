package com.arshad.CommonStepDefinition;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.arshad.Utility.CommonUtilities;
import com.arshad.WebDriver_manager.Driver_Manager;
import com.arshad.constants.Constants;
import com.arshad.page_object_model.Login_page;
import com.github.dockerjava.api.model.Driver;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Common_step_def {

	private static String Scenarioname;


	public static String getScenarioname() {
		return Scenarioname;
	}

	private static final Logger LOGGER = LogManager.getLogger(Common_step_def.class);
	@Before
	public void BeforeScenario(Scenario scenario) {

		LOGGER.info("Execution Started");
		try {
			Scenarioname =scenario.getName();
			LOGGER.info("Instantiating Common Utils");
			//CommonUtilities commonutilities = new CommonUtilities();
			LOGGER.info("Loading Properties");
			CommonUtilities.getInstance().loadproperties();
			LOGGER.info("Checking driver is null or not");
			if(Driver_Manager.getDriver()==null) {
				LOGGER.info("Driver is null instatianting it!");
				Driver_Manager.launchbrowser();
				CommonUtilities.getInstance().initWebelements();
				Login_Steps();
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtilities.getInstance().TakeScreenShot();
		}
	}

	
	public static void SCREENSHOTTAKEN(Scenario scenario) throws IOException, InterruptedException {
		
		
		Thread.sleep(2000);
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) Driver_Manager.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "error screen");
		Driver_Manager.getDriver().quit();
		}
		else {
			//System.out.println("Scenario Failed");
		}
	}
	public void Login_Steps() {

		Driver_Manager.getDriver().get(Constants.APP_URL);
		Driver_Manager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		Login_page.getinstance().enterusername();
		Login_page.getinstance().enterpassword();
		Login_page.getinstance().clickloginbtn();
	}


}
