package com.comcast.crm.generic.orgtest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationInfoPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class DeleteOrgTest {
	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		
		String BROWSER=flib.getDataFromProperties("browser");
		String URL=flib.getDataFromProperties("url");
		String USERNAME=flib.getDataFromProperties("username");
		String PASSWORD=flib.getDataFromProperties("password");
		
		//read data from Excel file
		
		String orgname = elib.getDataFromExcel("Organization", 10, 2)+jlib.getRandomNumber();
         
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}else
		{
			driver=new ChromeDriver();
		}
		 driver =new ChromeDriver();
		 
		 
		 
		 
		 //login to app
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp("url","admin", "password");
		
		
		
		//navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		//click on create organization button
		OrganizationPage cnp=new OrganizationPage(driver);
		cnp.getCreateOrgBtn().click();
		
		//step4 enter all detail and create 
		
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
		
		//go back to the organization page
		hp.getOrgLink().click();
		
		//search for orgnization
		cnp.getSearchEdt().sendKeys(orgname);
		wlib.select(cnp.getSearchDD(),"accountname");
		cnp.getSearchBtn().click();
		
		//In dynamic webtable select and delete org
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		
		Alert alert= driver.switchTo().alert();
		alert.accept();
		//step5 logout
		hp.logout();
		

	}
}
