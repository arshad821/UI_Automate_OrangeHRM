package com.arshad.page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arshad.Utility.CommonUtilities;

public class Home_page {
	
	private static Home_page HomepageInstance;
	
	private Home_page() {
		
	}
	
	public static Home_page getInstance() {
		
		if(HomepageInstance==null) {
			HomepageInstance=new Home_page();
		}
		return HomepageInstance;
		
	}

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a/span")
	private WebElement DIRECTORY;

	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a/span")
	private WebElement TIME;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span")
	private WebElement DASHBOARD;
	
	public void Directory() {
		CommonUtilities.getInstance().HighlightingWebElement(DIRECTORY);
		DIRECTORY.click();
	}
	
	public void time() {
		CommonUtilities.getInstance().HighlightingWebElement(TIME);
		TIME.click();
	}
	
	public void Dashboard() {
		CommonUtilities.getInstance().HighlightingWebElement(DASHBOARD);
		DASHBOARD.click();
	}
	
	
}
