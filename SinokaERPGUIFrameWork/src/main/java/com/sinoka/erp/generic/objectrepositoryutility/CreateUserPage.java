package com.sinoka.erp.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage 
{
	WebDriver driver;
	public CreateUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='New user']")
	private WebElement newUserLink;
	
	@FindBy(id="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(id="login")
	private WebElement loginEdt;
	
	@FindBy(id="password")
	private WebElement pswdEdt;
	
	
	@FindBy(xpath="//input[@value='Create user']")
	private WebElement createUserBtn;
	
	
	@FindBy(xpath="//a[@class='jnotify-close']")
	private WebElement alertCloseBtn;
	
	@FindBy(xpath="//a[text()='Disable']")
	private WebElement disableBtn;
	
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement disableacceptBtn;
	
	@FindBy(xpath="//span[text()='Disabled']")
	private WebElement disabledBtn;


	
	
	public WebElement getNewUserLink() {
		return newUserLink;
	}


	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}


	public WebElement getLoginEdt() {
		return loginEdt;
	}


	public WebElement getPswdEdt() {
		return pswdEdt;
	}


	public WebElement getCreateUserBtn() {
		return createUserBtn;
	}


	public WebElement getAlertCloseBtn() {
		return alertCloseBtn;
	}


	public WebElement getDisableBtn() {
		return disableBtn;
	}


	public WebElement getDisableacceptBtn() {
		return disableacceptBtn;
	}
	
	public WebElement getdisabledBtn() {
		return disabledBtn;
	}
	
	
	
	

}
