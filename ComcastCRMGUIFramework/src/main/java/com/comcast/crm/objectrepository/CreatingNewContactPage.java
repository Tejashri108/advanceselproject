package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
	public void allDate(String LastName,String StartDate,String EndDate)
	{
		lastname.sendKeys(LastName);
		startDate.clear();
		startDate.sendKeys(StartDate);
		
		endDate.sendKeys(EndDate);
	}
	

}
