package com.comcast.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;

public class BaseCLass {
	public WebDriver driver= null;
	public static WebDriver sdriver= null;
	public FileUtility flib= new FileUtility();
	public WebDriverUtility wlib= new WebDriverUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() {
		Reporter.log("===connect to DB, Report configuration===", true);
		
		
	}
	
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void configBT() {
		
		Reporter.log("Pre-condition", true);	
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws IOException {
	
		System.out.println("===Launch browser==");
		 String BROWSER = flib.getDataFromProperties("browser");
		
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
		sdriver= driver; //listener Implementation purpose
		UtilityClassObject.setDriver(driver);
		}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		
		String URL=flib.getDataFromProperties("url");
		String UNAME=flib.getDataFromProperties("username");
		String PWD= flib.getDataFromProperties("password");
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(URL,UNAME, PWD);
		
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		HomePage hp= new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		driver.quit();
	}
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void configAT() {
		Reporter.log("Post-condition", true);		
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() {
		Reporter.log("Closed the database connection, report back up", true);
		
	}

}
