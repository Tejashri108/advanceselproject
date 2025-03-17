package com.comcast.crm.generic.contacttest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseCLass;
import com.comcast.crm.objectrepository.ContactPage;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;

public class CreateContactTest extends BaseCLass {
    @Test(groups="smokeTest")
	public void createContactTest() throws Throwable
	{
	    //read testscript data from excel file
		String lastName=elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
         
		//navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactlnk().click();
		
		//click on create contact button
		ContactPage cp=new ContactPage(driver);
		cp.getNewCreateContactBtn().click();

		
		//step4 enter all detail and create organization
		CreatingNewContactPage ncp=new CreatingNewContactPage(driver);
		ncp.getLastname().sendKeys(lastName);
		ncp.getSaveBtn().click();
		
		
        //verify with pnone number info
		String actHeader=cp.getHeaderMsg().getText();
	    boolean status=actHeader.contains(lastName);
	    Assert.assertEquals(status, true);

	    String actLastName = cp.getLastNameMsg().getText();
	    SoftAssert soft=new SoftAssert();
	    soft.assertEquals(actLastName, lastName);
		
	    
		
		

	}

}
