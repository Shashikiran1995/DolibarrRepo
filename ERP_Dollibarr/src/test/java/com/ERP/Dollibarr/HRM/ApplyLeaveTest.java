package com.ERP.Dollibarr.HRM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v129.log.Log;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dollibarr.BaseUtility.BaseClass;
import com.Dollibarr.generic.ObjectRepositoryUtility.HomePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.LeaveInfoPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.LeavePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.ListOfUsersPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.LoginPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewLeavePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewUserPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.PermissionsPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.UserVerifyPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.UsersAndGroupsPage;
import com.Dollibarr.generic.WebDriverUtility.UtilityClassObject;
import com.aventstack.extentreports.Status;
@Listeners(com.Dollibarr.generic.ListenerUtility.ListenerImplimentation.class)
public class ApplyLeaveTest extends BaseClass
{
	@Test(groups = "ST")
	public void applyLeaveAsAdmin() throws EncryptedDocumentException, IOException
	{
		 String typeOfLeave = elib.getDataFromExcel("leave", 1, 1);
		 String startDay = elib.getDataFromExcel("leave", 1, 2);
		 String startMonth = elib.getDataFromExcel("leave", 1, 3);
		 String startYear = elib.getDataFromExcel("leave", 1, 4);
		 String endDay = elib.getDataFromExcel("leave", 1, 5);
		 String endMonth= elib.getDataFromExcel("leave", 1, 6);
		 String endYear= elib.getDataFromExcel("leave", 1, 7);
		 String approverName= elib.getDataFromExcel("leave", 1, 8);
		 
		 HomePage hp=new HomePage(driver);
		 hp.getHrmLink().click();
		 
		 LeavePage lp=new LeavePage(driver);
		 lp.getNewLeaveLink().click();
		 
		 NewLeavePage nlp=new NewLeavePage(driver);
		 nlp.getTypeOfLeaveDD().click();
		 nlp.getTypeOfLeaveSearchField().sendKeys(typeOfLeave);
		 nlp.getTypeOfLeaveSearchField().sendKeys(Keys.ENTER);
		 
		 nlp.selectStartDate(driver, startDay, startMonth, startYear);
		 nlp.selectEndDate(driver, endDay, endMonth, endYear);
		 
		 nlp.getApproverDD().click();
		 nlp.getAppoverSearchField().sendKeys(approverName);
		 nlp.getAppoverSearchField().sendKeys(Keys.ENTER);
		 
		 nlp.getSaveBtn().click();
		 
		 LeaveInfoPage lip=new LeaveInfoPage(driver);
		 boolean verify = lip.getValidateBtn().isDisplayed();
		 Assert.assertEquals(verify, true);
	}
	
	@Test
	public void applyLeaveAsUser() throws EncryptedDocumentException, IOException
	{
		String lastName = elib.getDataFromExcel("users", 1, 2)+jlib.getRandomNumber();
		String loginName = lastName;
		
		NewUserPage nup=new NewUserPage(driver);
		String password = nup.createUserWithMandatoryFileds(lastName, loginName, 1, 3);
		
		UserVerifyPage uvp=new UserVerifyPage(driver);
		uvp.getCancelNotify().click();
		String loginNameVerify = uvp.getLoginNameVerify().getText();
		boolean verify = loginNameVerify.trim().equals(loginName);
		Assert.assertEquals(verify, true);	
		
		HomePage hp=new HomePage(driver);
		hp.getUsersAndGroupsLink().click();

		UsersAndGroupsPage ugp=new UsersAndGroupsPage(driver);
		ugp.getListOfUsersLink().click();
		
		ListOfUsersPage lup=new ListOfUsersPage(driver);	
		lup.getLoginNameSearchEdit().sendKeys(loginName);
		lup.getLoginNameSearchEdit().sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='"+loginName+"']")).click();
		
		
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
		hp.logout();
		UtilityClassObject.getTest().log(Status.INFO, "Admin logout");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(loginName, password);
		UtilityClassObject.getTest().log(Status.INFO, "user "+loginName+" login");
		 hp.getHrmLink().click();
		 LeavePage leavePage=new LeavePage(driver);
		 leavePage.getNewLeaveLink().click();
		 
		 String typeOfLeave = elib.getDataFromExcel("leave", 1, 1);
		 String startDay = elib.getDataFromExcel("leave", 1, 2);
		 String startMonth = elib.getDataFromExcel("leave", 1, 3);
		 String startYear = elib.getDataFromExcel("leave", 1, 4);
		 String endDay = elib.getDataFromExcel("leave", 1, 5);
		 String endMonth= elib.getDataFromExcel("leave", 1, 6);
		 String endYear= elib.getDataFromExcel("leave", 1, 7);
		 String approverName= elib.getDataFromExcel("leave", 1, 8);
	 
		 NewLeavePage nlp=new NewLeavePage(driver);
		 nlp.getTypeOfLeaveDD().click();
		 nlp.getTypeOfLeaveSearchField().sendKeys(typeOfLeave);
		 nlp.getTypeOfLeaveSearchField().sendKeys(Keys.ENTER);
		 
		 nlp.selectStartDate(driver, startDay, startMonth, startYear);
		 nlp.selectEndDate(driver, endDay, endMonth, endYear);
		 
		 nlp.getApproverDD().click();
		 nlp.getAppoverSearchField().sendKeys(approverName);
		 nlp.getAppoverSearchField().sendKeys(Keys.ENTER);
		 
		 nlp.getSaveBtn().click();
		 
		 LeaveInfoPage lip=new LeaveInfoPage(driver);
		 boolean verifyLeave = lip.getValidateBtn().isDisplayed();
		 Assert.assertEquals(verifyLeave, true);
		
	}
	
}
