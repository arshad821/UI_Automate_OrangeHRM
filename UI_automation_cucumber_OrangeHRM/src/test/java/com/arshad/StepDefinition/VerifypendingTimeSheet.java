package com.arshad.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.arshad.Utility.CommonUtilities;
import com.arshad.WebDriver_manager.Driver_Manager;
import com.arshad.constants.Constants;
import com.arshad.page_object_model.Home_page;
import com.arshad.page_object_model.Login_page;
import com.arshad.page_object_model.Time_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifypendingTimeSheet {

	private static final Logger LOGGER = LogManager.getLogger(Verify_CEO_nameStepDef.class);
	@When("^user sucesfully logged on home page$")
	public void user_is_logged_in_succesfully_on_home_page() throws Throwable {


		try {
			//Login_steps;
			Home_page.getInstance().Dashboard();
			Thread.sleep(2000);
			String url=Driver_Manager.getDriver().getCurrentUrl();
			if(url.contains("dashboard")) 
			{
				LOGGER.info("user logged in succesfully on home page"); 
			}
		}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtilities.getInstance().TakeScreenShot();
			Assert.fail(e.getMessage());
		}}


	@Given("^when user clicks time option from menu bar$")
	public void when_user_clicks_time_option_from_menu_bar() throws Throwable {

		try {
			Home_page.getInstance().time();
			LOGGER.info("user clicked time option from menu bar");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtilities.getInstance().TakeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^user enters name as \"([^\"]*)\" and click view button$")
	public void user_enters_name_as_and_click_view_button(String arg1) throws Throwable {
		//System.out.println("user enters name as \\\"([^\\\"]*)\\\" and click view button");
		try {
			Time_Page.getInstance().enterempname();
			Time_Page.getInstance().view();
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtilities.getInstance().TakeScreenShot();
			Assert.fail(e.getMessage());
		}

	}

	@Then("^user should see the message as \"([^\"]*)\"$")
	public void user_should_see_the_message_as(String arg1) throws Throwable {
		try {
			String A_Message = Time_Page.getInstance().actualmessage.getText();
			System.out.println(A_Message);
			LOGGER.info("expected message seen");
			Driver_Manager.getDriver().close();
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtilities.getInstance().TakeScreenShot();
			Assert.fail(e.getMessage());
		}

	}


}
