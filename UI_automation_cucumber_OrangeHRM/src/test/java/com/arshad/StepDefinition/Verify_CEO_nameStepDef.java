package com.arshad.StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.arshad.CommonStepDefinition.Common_step_def;
import com.arshad.Utility.CommonUtilities;
import com.arshad.WebDriver_manager.Driver_Manager;
import com.arshad.constants.Constants;
import com.arshad.page_object_model.Directory_page;
import com.arshad.page_object_model.Home_page;
import com.arshad.page_object_model.Login_page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_CEO_nameStepDef {

	private static final Logger LOGGER = LogManager.getLogger(Verify_CEO_nameStepDef.class);

	@When("^user is logged in succesfully on home page$")
	public void user_is_logged_in_succesfully_on_home_page() throws Throwable {

		try {
			//Login_Steps
			String url =Driver_Manager.getDriver().getCurrentUrl();
			Thread.sleep(2000);
			System.out.println(url);
			if(url.contains("dashboard")) {
				LOGGER.info("user is logged in succesfully on home page");
				System.out.println("user is logged in succesfully on home page");//checking
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtilities.getInstance().TakeScreenShot();
			Assert.fail(e.getMessage()); // if above code fails it will print exception in console
		}


	}

	@Given("^when user clicks directory option from menu bar$")
	public void when_user_clicks_directory_option_from_menu_bar() throws Throwable {
		try {
			Home_page.getInstance().Directory();
			LOGGER.info("when user clicks directory option from menu bar");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtilities.getInstance().TakeScreenShot();
			Assert.fail(e.getMessage());
		}

	}

	@Given("user selects job title as HR from dropdown")
	public void user_selects_job_title_as_HR_from_dropdown() {

		try {
			Directory_page.getInstance().employeename();
			Directory_page.getInstance().jobtitle();
			Directory_page.getInstance().searchbtn();
			LOGGER.info("User entered name and clicked search button");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtilities.getInstance().TakeScreenShot();
			Assert.fail(e.getMessage());
		}


	}

	@Then("^user should see HR name as \"([^\"]*)\"$")
	public void user_should_see_HR_name_as(String expectedname) throws Throwable {
		try {
			String actualname= Directory_page.getInstance().NAME();
			System.out.println(actualname);
			if(actualname.equalsIgnoreCase(expectedname)) 
			{
			LOGGER.info("User now should see CEO name ");
			System.out.println("User now should see CEO name ");//for checking
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtilities.getInstance().TakeScreenShot();
			Assert.fail(e.getMessage());
		}

	}
	
}