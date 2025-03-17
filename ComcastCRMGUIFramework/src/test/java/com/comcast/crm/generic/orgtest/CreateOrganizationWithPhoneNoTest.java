package com.comcast.crm.generic.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganizationWithPhoneNoTest {

	public static void main(String[] args) throws IOException {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		
		
		
		String BROWSER=flib.getDataFromProperties("browser");
		String URL=flib.getDataFromProperties("url");
		String USERNAME=flib.getDataFromProperties("username");
		String PASSWORD=flib.getDataFromProperties("password");
		
		//read data from Excel file
		Random random=new Random();
	    int randomInt=	random.nextInt(1000);

		FileInputStream efis =new FileInputStream("./testData/Book1.xlsx");
		
		Workbook wb=WorkbookFactory.create(efis);
		Sheet sh=wb.getSheet("Organization");
		Row row=sh.getRow(7);
		String orgName = row.getCell(2).getStringCellValue()+randomInt;
		String phoneNumber = row.getCell(3).getStringCellValue();
		
		wb.close();
         
		
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
		
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step4 enter all detail and create organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone"));
		
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
        //verify with pnone number info

		String actphoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if(actphoneNumber.contains(phoneNumber))
		{
			System.out.println(phoneNumber+"is careated===pass");
		}else
		{
			System.out.println(phoneNumber+"is not created===fail");
		}
		
		//step5 logout
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img"))).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
		 driver.quit();

	}

}
