package com.arshad.Utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.arshad.CommonStepDefinition.Common_step_def;
import com.arshad.WebDriver_manager.Driver_Manager;
import com.arshad.constants.Constants;
import com.arshad.page_object_model.Directory_page;
import com.arshad.page_object_model.Home_page;
import com.arshad.page_object_model.Login_page;
import com.arshad.page_object_model.Time_Page;

public class CommonUtilities {

	private static CommonUtilities commonutilInstance=null;
	
	public CommonUtilities() {
		
	}
	
	public static CommonUtilities getInstance() {
		
		if(commonutilInstance==null) {
			commonutilInstance=new CommonUtilities();
		}
		
		return commonutilInstance;
		
	}
	
	public  void loadproperties() {

		Properties properties=new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.BROWSER =	properties.getProperty("BROWSER");
		Constants.USERNAME=properties.getProperty("USERNAME");
		Constants.PASSWORD=	properties.getProperty("PASSWORD");
		Constants.employee_name=	properties.getProperty("employee_name");
		Constants.Time_Emp_name = properties.getProperty("Time_employee_name");

	}

	public static void initWebelements() {
		PageFactory.initElements(Driver_Manager.getDriver(), Login_page.getinstance());
		PageFactory.initElements(Driver_Manager.getDriver(), Home_page.getInstance());
		PageFactory.initElements(Driver_Manager.getDriver(), Directory_page.getInstance());
		PageFactory.initElements(Driver_Manager.getDriver(), Time_Page.getInstance());
	}

	public void TakeScreenShot() {

		File screenshot = ((TakesScreenshot) Driver_Manager.getDriver()).getScreenshotAs(OutputType.FILE);
		//File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		//File destinationfile = new File("C:\\Users\\2143925\\OneDrive - Cognizant\\Desktop\\Screenshot\\screenshot3.png");
		try {
			FileHandler.copy(screenshot, new File( Common_step_def.getScenarioname() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void HighlightingWebElement(WebElement element) {
		
		JavascriptExecutor executor = (JavascriptExecutor) Driver_Manager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style', 'border : 5px solid yellow')", element);
	}

}
