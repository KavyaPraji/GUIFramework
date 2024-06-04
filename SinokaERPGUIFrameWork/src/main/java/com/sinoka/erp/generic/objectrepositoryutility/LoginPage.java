package com.sinoka.erp.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sinoka.erp.generic.webdriverutility.WebdriverUtility;

public class LoginPage extends WebdriverUtility
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private  WebElement usernameEdt;
	
	@FindBy(id="password")
	private  WebElement passwordEdt;
	
	@FindBy(xpath="//input[@type='submit']")
	private  WebElement loginBtn;
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void logininToApp(String url,String username,String password)
	{
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
		
		
		
	}
	
	

}
