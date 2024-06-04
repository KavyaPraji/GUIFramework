package com.sinoka.erp.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createGroupPage {
	WebDriver driver;

	public createGroupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='New group']")
	private WebElement newgrpLink;

	@FindBy(name = "nom")
	private WebElement grpnameEdt;

	@FindBy(xpath = "//input[@value='Create group']")
	private WebElement creategrpBtn;

	@FindBy(xpath = "//a[@class='butActionDelete']")
	private WebElement deleteGrpBtn;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement acceptBtn;

	public WebElement getNewgrpLink() {
		return newgrpLink;
	}

	public WebElement getGrpnameEdt() {
		return grpnameEdt;
	}

	public WebElement getCreategrpBtn() {
		return creategrpBtn;
	}

	public WebElement getdeleteGrpBtn() {
		return deleteGrpBtn;
	}

	public WebElement getAcceptBtn() {
		return acceptBtn;
	}
}
