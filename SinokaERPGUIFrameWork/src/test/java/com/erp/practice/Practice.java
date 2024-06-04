package com.erp.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sinoka.erp.generic.fileutility.FileUtility;

public class Practice {
	@Test
	public void launchBrowser() throws IOException
	{	
		WebDriver driver;
		System.out.println("Launch browser");
		FileUtility fLib=new FileUtility();
		String BROWSER = fLib.getDataFromProperties("browser");
		
		
		

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();

		}

		
	}
		
	}


