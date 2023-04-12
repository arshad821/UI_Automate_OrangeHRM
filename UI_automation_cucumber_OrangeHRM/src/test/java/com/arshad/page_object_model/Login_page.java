package com.arshad.page_object_model;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arshad.Utility.CommonUtilities;
import com.arshad.constants.Constants;

public class Login_page {
	
	private static Login_page LoginInstance;
	
	private Login_page() {
		
	}
	
	public static Login_page getinstance() {
		
		if(LoginInstance==null) {
			LoginInstance=new Login_page();
		}
		return LoginInstance;
	}
	
	
	
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	private WebElement USERNAME;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	private WebElement PASSWORD;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement LOGIN_BTN;

	/*
	 * public WebElement getUSERNAME() { return USERNAME; }
	 * 
	 * public WebElement getPASSWORD() { return PASSWORD; }
	 * 
	 * public WebElement getLOGIN_BTN() { return LOGIN_BTN; }
	 */

	
	public void enterusername() {
		CommonUtilities.getInstance().HighlightingWebElement(USERNAME);
		USERNAME.sendKeys(Constants.USERNAME);
	}
	public void enterpassword() {
		CommonUtilities.getInstance().HighlightingWebElement(PASSWORD);
		PASSWORD.sendKeys(Constants.PASSWORD);
	}
	public void clickloginbtn() {
		CommonUtilities.getInstance().HighlightingWebElement(LOGIN_BTN);
		LOGIN_BTN.click();
	}
}
