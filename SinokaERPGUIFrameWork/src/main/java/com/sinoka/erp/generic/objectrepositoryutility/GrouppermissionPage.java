package com.sinoka.erp.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrouppermissionPage
{
	
	WebDriver driver;
	public GrouppermissionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title='Group permissions']")
	private WebElement grppermisionLink;
	
	@FindBy(xpath="(//span[@title='Add'])[1]")
	private WebElement permAddBtn;

	public WebElement getGrppermisionLink() {
		return grppermisionLink;
	}

	public WebElement getPermAddBtn() {
		return permAddBtn;
	}

}
