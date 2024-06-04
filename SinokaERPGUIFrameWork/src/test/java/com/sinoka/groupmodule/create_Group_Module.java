package com.sinoka.groupmodule;

import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.sinoka.erp.generic.baseutility.BaseClass;
import com.sinoka.erp.generic.objectrepositoryutility.GrouppermissionPage;
import com.sinoka.erp.generic.objectrepositoryutility.HomePage;
import com.sinoka.erp.generic.objectrepositoryutility.createGroupPage;

public class create_Group_Module extends BaseClass {
	@Test(groups= {"smokeTest"})
	public void createGroupTest() throws Throwable {

		// End to End group creation-System Scenario

		HomePage hp = new HomePage(driver);

		createGroupPage cg = new createGroupPage(driver);

		String GRPNAME = fLib.getDataFromProperties("groupname") + jlib.getRandomNum();
		// String GRPNAME=eLib.getDataFromExcel("sheet1",1,1)+jlib.getRandomNum();

		hp.getUsrandgrpLink().click();

		cg.getNewgrpLink().click();

		cg.getGrpnameEdt().sendKeys(GRPNAME);

		cg.getCreategrpBtn().click();

		// verification

		String headerInfo = driver.findElement(By.xpath("(//div[contains(@class,'inline-block floatlef')])[2]"))
				.getText();

		if (headerInfo.contains(GRPNAME)) {
			System.out.println(GRPNAME + " header verified===PASS");
		} else {
			System.out.println(GRPNAME + " header verified===FAIL");

		}

	}

	@Test(groups= {"regressionTest"})
	public void assignGroupPermissionTest() throws IOException {

		// End-to-End Group assignment-System scenario

		HomePage hp = new HomePage(driver);

		createGroupPage cg = new createGroupPage(driver);

		GrouppermissionPage gp = new GrouppermissionPage(driver);

		String GRPNAME = fLib.getDataFromProperties("groupname") + jlib.getRandomNum();

		hp.getUsrandgrpLink().click();

		cg.getNewgrpLink().click();

		cg.getGrpnameEdt().sendKeys(GRPNAME);

		cg.getCreategrpBtn().click();

		gp.getGrppermisionLink().click();

		gp.getPermAddBtn().click();

		// verification

		if (gp.getPermAddBtn().isEnabled()) {
			System.out.println("Group Permission Assigned==PASS");
		} else {
			System.out.println("Group Permission not Assigned==FAIL");
		}

	}

	@Test(groups= {"regressionTest"})
	public void DeleteGroupTest() throws Throwable {
		HomePage hp = new HomePage(driver);

		createGroupPage cg = new createGroupPage(driver);

		String GRPNAME = fLib.getDataFromProperties("groupname") + jlib.getRandomNum();
		// String GRPNAME=eLib.getDataFromExcel("sheet1",1,1)+jlib.getRandomNum();

		hp.getUsrandgrpLink().click();

		cg.getNewgrpLink().click();

		cg.getGrpnameEdt().sendKeys(GRPNAME);

		cg.getCreategrpBtn().click();

		cg.getdeleteGrpBtn().click();

		cg.getAcceptBtn().click();

	}

}
