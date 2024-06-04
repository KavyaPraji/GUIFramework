package com.sinoka.erp.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createGroupWithUserPage
{
	WebDriver driver;
	public createGroupWithUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="select2-user-container")
	private WebElement addUserTextbox;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement addUsersearchbox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement addBtn;
	
	
	
	public WebElement getAddUserTextbox() {
		return addUserTextbox;
	}

	public WebElement getAddUsersearchbox() {
		return addUsersearchbox;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}


}
