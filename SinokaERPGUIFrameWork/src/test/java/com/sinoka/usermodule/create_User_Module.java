package com.sinoka.usermodule;

import java.io.IOException;


import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.sinoka.erp.generic.baseutility.BaseClass;
import com.sinoka.erp.generic.objectrepositoryutility.CreateUserPage;
import com.sinoka.erp.generic.objectrepositoryutility.HomePage;
import com.sinoka.erp.generic.objectrepositoryutility.createGroupPage;
import com.sinoka.erp.generic.objectrepositoryutility.createGroupWithUserPage;

//com.sinoka.erp.ListnerUtility
public class create_User_Module extends BaseClass {
	String LASTNAME;

	@Test(groups= {"smokeTest"})
	public void createUserTest() throws IOException, InterruptedException {
		// End-to-End UserCreation-System scenario
		CreateUserPage cup = new CreateUserPage(driver);

		HomePage hp = new HomePage(driver);

		hp.getUsrandgrpLink().click();

		cup.getNewUserLink().click();

		LASTNAME = fLib.getDataFromProperties("lastname") + jlib.getRandomNum();

		String LOGIN_NAME = LASTNAME + jlib.getRandomNum();

		String PASSWORD = fLib.getDataFromProperties("user_password") + jlib.getRandomNum();

		cup.getLastnameEdt().sendKeys(LASTNAME);

		cup.getLoginEdt().sendKeys(LOGIN_NAME);

		cup.getPswdEdt().clear();
		cup.getPswdEdt().sendKeys(PASSWORD);

		cup.getCreateUserBtn().click();

		cup.getAlertCloseBtn().click();

		/// verification
		String headerInfo = driver.findElement(By.xpath("//div[contains(@class,'inline-block floatleft vali')]"))
				.getText();

		if (headerInfo.contains(LASTNAME)) {
			System.out.println(LASTNAME + " header verified===PASS");
		}

		else {
			System.out.println(LASTNAME + " header verified===FAIL");
		}

	}

	@Test(groups= {"regressionTest"})
	public void mappingUserToGroupTest() throws Throwable {
		// End-to-End mapping-System scenario

		// create user

		CreateUserPage cup = new CreateUserPage(driver);

		HomePage hp = new HomePage(driver);

		createGroupWithUserPage cgu = new createGroupWithUserPage(driver);

		hp.getUsrandgrpLink().click();

		cup.getNewUserLink().click();

		LASTNAME = fLib.getDataFromProperties("lastname") + jlib.getRandomNum();

		String LOGIN_NAME = LASTNAME + jlib.getRandomNum();

		String PASSWORD = fLib.getDataFromProperties("user_password") + jlib.getRandomNum();

		cup.getLastnameEdt().sendKeys(LASTNAME);

		cup.getLoginEdt().sendKeys(LOGIN_NAME);

		cup.getPswdEdt().clear();
		cup.getPswdEdt().sendKeys(PASSWORD);

		cup.getCreateUserBtn().click();

		cup.getAlertCloseBtn().click();

		// create group

		createGroupPage cg = new createGroupPage(driver);

		String GRPNAME = fLib.getDataFromProperties("groupname") + jlib.getRandomNum();

		cg.getNewgrpLink().click();

		cg.getGrpnameEdt().sendKeys(GRPNAME);

		cg.getCreategrpBtn().click();

		// mapping user to group

		cgu.getAddUserTextbox().click();

		cgu.getAddUsersearchbox().sendKeys(LASTNAME);

		wLib.pressEnter(driver);

		cgu.getAddBtn().click();

		// verification

		String userinfo = driver.findElement(By.xpath("//span[@class='nopadding usertext']")).getText();

		if (userinfo.contains(LASTNAME)) {
			System.out.println("mapping " + LASTNAME + "with" + GRPNAME + "is succesfull==PASS");

		} else {

			System.out.println("mapping " + LASTNAME + "with" + GRPNAME + "is  not succesfull==FAIL");
		}

	}
	
	@Test(groups= {"regressionTest"})
	public void disableUser() throws Throwable
	{
		
		//Disable created user-Integration
		
		//create user
		
		CreateUserPage cup = new CreateUserPage(driver);

		HomePage hp = new HomePage(driver);

		
		hp.getUsrandgrpLink().click();

		cup.getNewUserLink().click();

		LASTNAME = fLib.getDataFromProperties("lastname") + jlib.getRandomNum();

		String LOGIN_NAME = LASTNAME + jlib.getRandomNum();

		String PASSWORD = fLib.getDataFromProperties("user_password") + jlib.getRandomNum();

		cup.getLastnameEdt().sendKeys(LASTNAME);

		cup.getLoginEdt().sendKeys(LOGIN_NAME);

		cup.getPswdEdt().clear();
		cup.getPswdEdt().sendKeys(PASSWORD);

		cup.getCreateUserBtn().click();

		cup.getAlertCloseBtn().click();
		
		//disable user
		
		cup.getDisableBtn().click();
		
		cup. getDisableacceptBtn().click();
		
		String disableInfo=cup.getdisabledBtn().getText();
		
	
		
		if(disableInfo.equals("Disabled"))
		{
			System.out.println("Created user disabled");
		}
		else
		{
			System.out.println("Created user enabled");
		}

				

	}

}
