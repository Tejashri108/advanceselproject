package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	 public LoginPage(WebDriver driver)
		{    this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
    @FindBy(name="user_name")
    WebElement usernameEdt;
    
    @FindBy(name="user_password")
    WebElement passwordEdt;
    
    @FindBy(id="submitButton")
    WebElement loginBtn;
    
    
    
    public WebElement getUsernameEdt() {
		return usernameEdt;
	}


   public WebElement getPasswordEdt() {
		return passwordEdt;
	}


    public WebElement getLoginBtn() {
		return loginBtn;
	}
    //step5:provide action
    public void loginToApp(String url,String username,String password)
    {
        driver.manage().window().maximize(); 
        driver.get(url);
        usernameEdt.sendKeys(username);
    	passwordEdt.sendKeys(password);
    	loginBtn.click();    	
    }

    
    

}
