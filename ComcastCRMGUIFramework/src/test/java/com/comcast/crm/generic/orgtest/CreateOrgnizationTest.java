package com.comcast.crm.generic.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseCLass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerUtility.ListenerImpClass;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationInfoPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class CreateOrgnizationTest extends BaseCLass {
	@Test(groups="smokeTest")
	public void createOrgnizationTest() throws Throwable, IOException
	{
		UtilityClassObject.getTest().log(Status.INFO,"Read data from excel");
		//read data from Excel file
		String orgname = elib.getDataFromExcel("organization", 1, 2)+jlib.getRandomNumber();
      
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 //navigate to organization module
		 UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		//click on create organization button
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to create orgpage");
		OrganizationPage cnp=new OrganizationPage(driver);
		cnp.getCreateOrgBtn().click();
		
		//step4 enter all detail and create 
		UtilityClassObject.getTest().log(Status.INFO,"create neworg");
		
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);
		
		//verify Header msg expected result
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		
		if(actOrgName.contains(orgname))
    	{
			System.out.println(orgname+ "name is verified===PASS");
		}else
		{
			System.out.println(orgname+ "name is verified===FAIL");
		}
		
		
		

	}
	

}
