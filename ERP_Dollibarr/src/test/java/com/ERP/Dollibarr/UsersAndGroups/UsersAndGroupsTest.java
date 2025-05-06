package com.ERP.Dollibarr.UsersAndGroups;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dollibarr.BaseUtility.BaseClass;
import com.Dollibarr.generic.ObjectRepositoryUtility.HomePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.ListOfUsersPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewUserPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.PermissionsPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.UserVerifyPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.UsersAndGroupsPage;

public class UsersAndGroupsTest extends BaseClass
{
	String loginName;
	@Test(groups = "ST")
	public void createUserTest() throws EncryptedDocumentException, IOException
	{
		String lastName = elib.getDataFromExcel("users", 1, 2)+jlib.getRandomNumber();
		loginName = lastName;
		
		NewUserPage nup=new NewUserPage(driver);
		nup.createUserWithMandatoryFileds(lastName, loginName, 1, 3);
		
		UserVerifyPage uvp=new UserVerifyPage(driver);
		uvp.getCancelNotify().click();
		String loginNameVerify = uvp.getLoginNameVerify().getText();
		boolean verify = loginNameVerify.trim().equals(loginName);
		Assert.assertEquals(verify, true);	
	}
	
	@Test(dependsOnMethods = "createUserTest" , groups = "RT")
	public void permisssionsEnablingTest()
	{
		HomePage hp=new HomePage(driver);
		hp.getUsersAndGroupsLink().click();

		UsersAndGroupsPage ugp=new UsersAndGroupsPage(driver);
		ugp.getListOfUsersLink().click();
		
		ListOfUsersPage lup=new ListOfUsersPage(driver);	
		lup.getLoginNameSearchEdit().sendKeys(loginName);
		lup.getLoginNameSearchEdit().sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='"+loginName+"']")).click();
		
		UserVerifyPage uvp=new UserVerifyPage(driver);
		uvp.getPermissionsBtn().click();
		
		PermissionsPage pp=new PermissionsPage(driver);
		pp.getReadUsersToggle().click();
		pp.getModifyOwnInfoToggle().click();
		pp.getModifyOwnPasswordToggle().click();
		pp.getLeaveRequestAllLink().click();
		
		String num = pp.getPermissionsVerify().getText();
		int no=Integer.parseInt(num);
		if(!(no>0))
		{
		  Assert.fail();	
		}
	}
	
	
}
