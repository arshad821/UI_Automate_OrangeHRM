package com.arshad.page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arshad.Utility.CommonUtilities;
import com.arshad.constants.Constants;

public class Time_Page {


	private static Time_Page TimepageInstance;

	private  Time_Page() {
		
	}
	public static Time_Page getInstance() {

		if(TimepageInstance==null) {
			TimepageInstance=new Time_Page();
		}
		return TimepageInstance;

	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/div/div/input")
	public WebElement employee_name;
	
	@FindBy(xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/div/div[2]/div/span")
    public WebElement selectempname; 
    
    
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[2]/button")
	public WebElement view_btn;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/div/div[1]/p")
	public WebElement actualmessage;
	
	public void enterempname() throws InterruptedException {
		CommonUtilities.getInstance().HighlightingWebElement(employee_name);
		employee_name.sendKeys(Constants.Time_Emp_name);
		Thread.sleep(2000);
		selectempname.click();
	}
	public void view() {
		
		view_btn.click();
	}
}
