package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlnk;
	
	@FindBy(linkText="More")
	private WebElement morelnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getMorelnk() {
		return morelnk;
	}

	public WebElement getCampaignLnk() {
		return campaignLnk;
	}

	@FindBy(linkText="Campaigns")
	private WebElement campaignLnk;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}


	public void navigateToCampaignPage()
	{
		Actions act=new Actions(driver);
		act.moveToElement(morelnk).perform();
		campaignLnk.click();
	}
	public void logout()
	
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLink.click();
	}

}
