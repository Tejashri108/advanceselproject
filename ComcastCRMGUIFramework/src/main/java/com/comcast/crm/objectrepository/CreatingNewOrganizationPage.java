package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
   public void createOrg(String orgName)
       {
	   orgNameEdt.sendKeys(orgName);
	   saveBtn.click();
       }
   
   
  
	
	@FindBy(name = "accountname")
	private WebElement orgNameTF;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;
	
	

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	
	
	public void createOrg(String orgName, String industry, String type) {
		orgNameEdt.sendKeys(orgName);
		Select sel1= new Select(industryDD);
		sel1.selectByVisibleText(industry);
		
		saveBtn.click();
	}
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	@FindBy(name= "search_field")
	private WebElement searchDD;
	
	@FindBy(name= "submit")
	private WebElement searchButton;
	

}
