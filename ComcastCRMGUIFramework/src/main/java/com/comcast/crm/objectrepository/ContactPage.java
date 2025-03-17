package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement newCreateContactBtn;
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameMsg;

	public WebElement getNewCreateContactBtn() {
		return newCreateContactBtn;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getLastNameMsg() {
		return lastNameMsg;
	}
	
	

}
