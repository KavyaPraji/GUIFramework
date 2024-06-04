package com.sinoka.erp.generic.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sinoka.erp.generic.databaseutility.DatabaseUtility;
import com.sinoka.erp.generic.fileutility.ExcelUtility;
import com.sinoka.erp.generic.fileutility.FileUtility;
import com.sinoka.erp.generic.objectrepositoryutility.HomePage;
import com.sinoka.erp.generic.objectrepositoryutility.LoginPage;
import com.sinoka.erp.generic.webdriverutility.JavaUtility;
import com.sinoka.erp.generic.webdriverutility.UtilityClassObject;
import com.sinoka.erp.generic.webdriverutility.WebdriverUtility;

public class BaseClass
{
	public WebDriver driver = null;
	public DatabaseUtility dbLib = new DatabaseUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebdriverUtility wLib=new WebdriverUtility();
	
	public static WebDriver sdriver = null;
	
	
	

	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBs() {
		System.out.println("connect to DB,Report Config");
		dbLib.getDbConnection();
	}
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBc() throws IOException {
		System.out.println("Launch browser");
		FileUtility fLib=new FileUtility();
		String BROWSER =fLib.getDataFromProperties("browser");
		
		
		

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();

		}

		sdriver=driver;
		UtilityClassObject.setDriver(driver);

	}

	

	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBm() throws IOException {

		System.out.println("login into application");
		String URL = fLib.getDataFromProperties("url");
		String USERNAME = fLib.getDataFromProperties("username");
		String PASSWORD = fLib.getDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);

		lp.logininToApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAm() {
		System.out.println("logout from application");
		HomePage hp = new HomePage(driver);
		hp.getAdminBtn().click();
		hp.getLogoutBtn().click();
		
		

	}

	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAc() {
		System.out.println("close the browser");
		driver.close();
	}

	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAs() throws SQLException {
		System.out.println("close DB ,Report backup");
		dbLib.closeDbConnection();
	}

}
