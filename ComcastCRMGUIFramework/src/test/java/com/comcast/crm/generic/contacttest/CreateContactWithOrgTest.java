package com.comcast.crm.generic.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.basetest.BaseCLass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest extends BaseCLass {

	public void createContactWithOrgTest() throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		//read data from Excel file
		
		String orgName = elib.getDataFromExcel("contact", 7, 2)+jlib.getRandomNumber();
		String contactLastName = elib.getDataFromExcel("contact",7,3);
		
		//navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step4 enter all detail and create organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone"));
		
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
        //verify  Headerpnone number info
        
        String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName))
		{
			System.out.println(orgName+"is careated===pass");
		}else
		{
			System.out.println(orgName+"is not created===fail");
		}
		
		//Step5 navigate to contact module
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//step6-click on create contact button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step7 enter all detail and create contact
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//step8switch to child window
		wlib.switchToTabOnURL(driver, "module=Accounts");
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//switch to parent window
		wlib.switchToTabOnURL(driver, "COntacts&action");
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify header phone number info
		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(contactLastName))
		{
			System.out.println(contactLastName+"is careated===pass");
		}else
		{
			System.out.println(contactLastName+"is not created===fail");
		}
		
		//verify orgname info expected result
		String actorgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actorgname.contains(orgName))
		{
			System.out.println(orgName+"is careated===pass");
		}else
		{
			System.out.println(orgName+"is not created===fail");
		}
		
		
        
		//step5 logout
		
		 driver.quit();
	}

	}

