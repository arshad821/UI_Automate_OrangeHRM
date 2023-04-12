package com.arshad.page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arshad.Utility.CommonUtilities;
import com.arshad.constants.Constants;

public class Directory_page {

	private static Directory_page DirectorypageInsatance;

	private Directory_page() {

	}

	public static Directory_page getInstance() {

		if(DirectorypageInsatance==null) {
			DirectorypageInsatance=new Directory_page();
		}
		return DirectorypageInsatance;

	}


	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
	private WebElement EMPLOYEE_NAME;

	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/span")
	private WebElement CEONAME;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement SEARCH_BTN;

	@FindBy(xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]/span")
	private WebElement CEOposition;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div")
	private WebElement JOBTITLE;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']")
	private WebElement ActualName;

	public void employeename() {
		CommonUtilities.getInstance().HighlightingWebElement(EMPLOYEE_NAME);
		EMPLOYEE_NAME.sendKeys(Constants.employee_name);
		CEONAME.click();
	}
	
	public void searchbtn() {
		SEARCH_BTN.click();
	}
	

	public void jobtitle() {
		
		JOBTITLE.click();
		CEOposition.click();
	}
	
	
	public String NAME() {
		CommonUtilities.getInstance().HighlightingWebElement(ActualName);
		return ActualName.getText();
	}
}
