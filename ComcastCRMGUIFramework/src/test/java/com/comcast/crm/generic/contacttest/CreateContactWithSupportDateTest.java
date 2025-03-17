package com.comcast.crm.generic.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseCLass;
import com.comcast.crm.objectrepository.ContactInfoPage;
import com.comcast.crm.objectrepository.ContactPage;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;


public class CreateContactWithSupportDateTest extends BaseCLass {
     @Test
	public void CreateContactWithSupportDateTest() throws Throwable, Throwable{
		
	
		String lastName = elib.getDataFromExcel("Organization", 4, 2)+jlib.getRandomNumber();
		
		
		//navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactlnk().click();
		
		
		//	driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact button
		ContactPage cp=new ContactPage(driver);
		cp.getNewCreateContactBtn().click();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step4 enter all detail and create organization
		String endDate=jlib.getSystemDateyyyMMdd();
		String startDate=jlib.getRequiredDateyyyMMdd(30);
		
		/*driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.id("Support Start Date")).clear();
		driver.findElement(By.id("Support Start Date")).sendKeys("startDate");*/
		
		CreatingNewContactPage ncp= new CreatingNewContactPage(driver);
		ncp.allDate(lastName, startDate, endDate);
		ncp.getSaveBtn();
		/*driver.findElement(By.id("dtlview_Support End Date")).clear();
		driver.findElement(By.id("Support End Date")).sendKeys("endDate");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
        //verify with pnone number info

		
		/*  ContactInfoPage cip=new ContactInfoPage(driver);
			String actStartDate = cip.getCreatedLastName().getText();
			if(actStartDate.contains(startDate))
			{
				System.out.println(startDate+"is careated===pass");
			}else
			{
				System.out.println(startDate+"is not created===fail");
			}
	
		
       /* ContactInfoPage cip=new ContactInfoPage(driver);
		String actStartDate = cip.getCreatedLastName().getText();
		if(actStartDate.contains(startDate))
		{
			System.out.println(startDate+"is careated===pass");
		}else
		{
			System.out.println(startDate+"is not created===fail");
		}
		
		/*OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		
		if(actOrgName.contains(orgname))
    	{
			System.out.println(orgname+ "name is verified===PASS");
		}else
		{
			System.out.println(orgname+ "name is verified===FAIL");
		}*/
		
		
		

		/*String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actEndDate.contains(endDate))
		{
			System.out.println(endDate+"is careated===pass");
		}else
		{
			System.out.println(endDate+"is not created===fail");
		}*/
		
		//step5 logout
		
		 
	}

}
