package com.sinoka.erp.generic.webdriverutility;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility 
{
	public void waitForPageToLoad(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
		
	}
	public void switchToTabonURL(WebDriver driver,String partialURL)
	{
		Set<String> child=driver.getWindowHandles();
		Iterator<String> it=child.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			driver.switchTo().window(windowID);
			
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialURL))
			{
				break;
									}
			
		}
	}
	public void switchToTabonTitle(WebDriver driver,String partialTitle)
	{
		Set<String> child=driver.getWindowHandles();
		Iterator<String> it=child.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			driver.switchTo().window(windowID);
			
			String actTitle=driver.getTitle();
			if(actTitle.contains(partialTitle))
			{
				break;
									}
			
		}
	}
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		
	}
	public void switchToFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
		
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
		
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();; 
		
	}
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	public void Select(WebElement element,String text )
	{
				Select sel=new Select(element);
				sel.selectByVisibleText(text);
	}
	public void Select(WebElement element,int Index)
	{
				Select sel=new Select(element);
				sel.selectByIndex(Index);
	}
	public void mousemoveOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
				
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
		
	}
	public void IgnoreNotification(WebDriver driver)
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-Notifications");
		
	}
	
	public void pressEnter(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
	}
	
	
	
	
		
	
	

}
