package com.ERP.Dollibarr.ThirdParty;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dollibarr.BaseUtility.BaseClass;
import com.Dollibarr.generic.ObjectRepositoryUtility.ContactsOrAddressesInfoPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.ContactsOrAddressesPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.HomePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.ListOfUsersPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.LoginPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewContactsOrAddressesPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewThirdPartyPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.PermissionsPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.ThirdPartyPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.ThirdPartyVerifyPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.UserVerifyPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.UsersAndGroupsPage;

public class CreateContactsOrAddressesTest extends BaseClass
{
	@Test
	public void createContactOrAddressesTest() throws EncryptedDocumentException, IOException
	{
		String thirdPartyName = elib.getDataFromExcel("thirdParty", 1, 1)+jlib.getRandomNumber();
		String prospectOrCustomer = elib.getDataFromExcel("thirdParty", 1, 2);
		String vendorOrNot = elib.getDataFromExcel("thirdParty", 1, 3);
		
		NewThirdPartyPage ntp=new NewThirdPartyPage(driver);
		ntp.createThirdParty(thirdPartyName, prospectOrCustomer, vendorOrNot);
		
		ThirdPartyVerifyPage tpv=new ThirdPartyVerifyPage(driver);
		String actThirdParty = tpv.getThirdPartyNameVerify().getText();
		boolean verify = actThirdParty.contains(thirdPartyName);
		Assert.assertEquals(verify, true);
		
		String lastName = elib.getDataFromExcel("contactsOrAddresses", 1, 1)+jlib.getRandomNumber();
		ContactsOrAddressesPage coap=new ContactsOrAddressesPage(driver);
		coap.getNewContactsOrAddressesLink().click();
		
		NewContactsOrAddressesPage ncoa=new NewContactsOrAddressesPage(driver);
		ncoa.getLastNameEdit().sendKeys(lastName);
		ncoa.getSelectThirdPartyDD().click();
		ncoa.getSelectThirdPartySearchField().sendKeys(thirdPartyName);
		ncoa.getSelectThirdPartySearchField().sendKeys(Keys.ENTER);
		ncoa.getSubmitBtn().click();
		
		ContactsOrAddressesInfoPage coip=new ContactsOrAddressesInfoPage(driver);
		coip.getCreateAUserLink().click();
		
		String loginId = coip.getLoginId().getDomAttribute("value");
		String password = coip.getPassword().getDomAttribute("value");
		elib.setDataIntoExcel("contactsOrAddresses", 1, 2, loginId);
		elib.setDataIntoExcel("contactsOrAddresses", 1, 3, password);
		coip.getValidateBtn().click();
		
		boolean loginIdVerify = driver.findElement(By.xpath("//a[text()='"+loginId+"']")).isDisplayed();
		Assert.assertEquals(loginIdVerify, true);
		
		HomePage hp=new HomePage(driver);
		hp.getHomeLink().click();
		
		hp.getUsersAndGroupsLink().click();

		UsersAndGroupsPage ugp=new UsersAndGroupsPage(driver);
		ugp.getListOfUsersLink().click();
		
		ListOfUsersPage lup=new ListOfUsersPage(driver);	
		lup.getLoginNameSearchEdit().sendKeys(loginId);
		lup.getLoginNameSearchEdit().sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='"+loginId+"']")).click();
		
		UserVerifyPage uvp=new UserVerifyPage(driver);
		uvp.getPermissionsBtn().click();
		
		PermissionsPage pp=new PermissionsPage(driver);
		pp.getReadUsersToggle().click();
		pp.getModifyOwnInfoToggle().click();
		pp.getModifyOwnPasswordToggle().click();
		pp.getThirdPartyAllAccess().click();
		pp.getLeaveRequestAllLink().click();
		
		String num = pp.getPermissionsVerify().getText();
		int no=Integer.parseInt(num);
		if(!(no>0))
		{
		  Assert.fail();	
		}
		
		hp.logout();
		
		LoginPage lp=new LoginPage(driver);
		lp.login(loginId, password);
		
		hp.getThirdPartiesLink().click();
		
		ThirdPartyPage tpp=new ThirdPartyPage(driver);
		boolean thirdPartPageVerify = tpp.getThirdPartyPageVerify().isDisplayed();
		Assert.assertEquals(thirdPartPageVerify, true);
	}
}
