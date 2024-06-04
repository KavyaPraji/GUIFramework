package com.sinoka.erp.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sinoka.erp.generic.webdriverutility.WebdriverUtility;

public class HomePage extends WebdriverUtility {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Users & Groups']")
	private WebElement usrandgrpLink;

	@FindBy(xpath = "//span[text()='admin']")
	private WebElement adminBtn;

	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logoutBtn;

	public WebElement getUsrandgrpLink() {
		return usrandgrpLink;
	}

	public WebElement getAdminBtn() {
		return adminBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

}
