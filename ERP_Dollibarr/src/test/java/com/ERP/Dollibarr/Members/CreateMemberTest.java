package com.ERP.Dollibarr.Members;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dollibarr.BaseUtility.BaseClass;
import com.Dollibarr.generic.FileUtility.ExcelUtility;
import com.Dollibarr.generic.ObjectRepositoryUtility.HomePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.MemberInfoPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.MembersPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewMemberPage;

public class CreateMemberTest extends BaseClass
{
	@DataProvider
	public Object[][] data() throws Exception
	{
		ExcelUtility elib=new ExcelUtility();
		int rowCount = elib.getLastRowNum("members2");
		short cellCount = elib.getLastCellNum("members2", 0);
		System.out.println(rowCount);
		System.out.println(cellCount);
		Object[][] objarr=new Object[rowCount][cellCount-1];
		
		try 
		{
			for(int i=0;i<rowCount;i++)
			{
				for(int j=0;j<cellCount;j++) {
				objarr[i][j]=elib.getDataFromExcel("members2", i+1, j+1);
				
				}
			}
		}
		catch(Exception e) 
		{
			
		}
		return objarr;
	}
	@Test(groups = "ST")
	public void createMemberWithMndatoryFields() throws EncryptedDocumentException, IOException
	{
		String memberType = elib.getDataFromExcel("members1", 1, 1);
		String natureOfMember = elib.getDataFromExcel("members1", 1, 2);
		String companyName = elib.getDataFromExcel("members1", 1, 3);
		String title = elib.getDataFromExcel("members1", 1, 4);
		String lastName = elib.getDataFromExcel("members1", 1, 5)+jlib.getRandomNumber();
		String firstName = elib.getDataFromExcel("members1", 1, 6)+jlib.getRandomNumber();
		//System.out.println(memberType);
		
		HomePage hp=new HomePage(driver);
		hp.getMembersLink().click();
		
		MembersPage mp=new MembersPage(driver);
		mp.getNewMemberLink().click();
		
		NewMemberPage nmp=new NewMemberPage(driver);
		nmp.getMemberTypeDD().click();
		
		driver.findElement(By.xpath("//li[text()='"+memberType+"']")).click();
		
		nmp.getNatureOfMemberDD().click();
		
		driver.findElement(By.xpath("//li[text()='"+natureOfMember+"']")).click();
		
		nmp.getLastNameEdit().sendKeys(lastName);
		nmp.getFirstNameEdit().sendKeys(firstName);
		
		nmp.getSaveBtn().click();
		
		MemberInfoPage mip=new MemberInfoPage(driver);
		/*driver.findElement(By.xpath("//div[text()='"+lastName+" "+firstName+" ']"));*/
		String header = mip.getMemberVerifyElement().getText();
		boolean verify = header.contains(firstName);
		Assert.assertEquals(verify, true);
		
	}
	
	@Test(dataProvider = "data", groups = "RT")
	public void createMemberWithEnteringAllFields(String memberType,String natureOfMember,String companyName,String title,
			String lastName,String firstName,String gender,String email,String web,String address,String city,
			String country,String state,String Bphone,String Pphone,String mobile,String day,String month,String year,String NULL) throws Exception
	{
//		String memberType = elib.getDataFromExcel("members", 1, 1);
//		String natureOfMember = elib.getDataFromExcel("members", 1, 2);
//		String companyName = elib.getDataFromExcel("members", 1, 3)+ jlib.getRandomNumber();
//		String lastName = elib.getDataFromExcel("members", 1, 5)+jlib.getRandomNumber();
//		String firstName = elib.getDataFromExcel("members", 1, 6)+jlib.getRandomNumber();
//		int rowCount = elib.getLastRowNum("members");
		//System.out.println(memberType);
		
		HomePage hp=new HomePage(driver);
		hp.getMembersLink().click();
		
		MembersPage mp=new MembersPage(driver);
		mp.getNewMemberLink().click();
		
		NewMemberPage nmp=new NewMemberPage(driver);
		nmp.getMemberTypeDD().click();
		
		driver.findElement(By.xpath("//li[text()='"+memberType+"']")).click();
		
		nmp.getNatureOfMemberDD().click();
		
		driver.findElement(By.xpath("//li[text()='"+natureOfMember+"']")).click();
		
		nmp.getLastNameEdit().sendKeys(lastName);
		nmp.getFirstNameEdit().sendKeys(firstName);
		
		nmp.getGenderDD().click();
		WebElement ele = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		ele.sendKeys(gender);
		ele.sendKeys(Keys.ENTER);
//		nmp.getGenderDD().click();
//		driver.findElement(By.xpath("li[text()='"+gender+"']")).click();
		
		nmp.getEmailEdit().sendKeys(email);
		nmp.getWebEdit().sendKeys(web);
		nmp.getAddressEdit().sendKeys(address);
		nmp.getCityEdit().sendKeys(city);
		nmp.getCountryEdit().click();
		driver.findElement(By.xpath("//li[contains(text(),'"+country+"')]")).click();
		nmp.getStateEdit().click();
		driver.findElement(By.xpath("//li[contains(text(),'"+state+"')]")).click();
		nmp.getbPhoneEdit().sendKeys(Bphone);
		nmp.getpPhoneEdit().sendKeys(Pphone);
		nmp.getmPhoneEdit().sendKeys(mobile);
		nmp.selectDate(driver, day, month, year);
		wlib.selectByVisibleText(nmp.getPublicSelectDD(), "Yes");
		nmp.getSaveBtn().click();
		
		MemberInfoPage mip=new MemberInfoPage(driver);
		/*driver.findElement(By.xpath("//div[text()='"+lastName+" "+firstName+" ']"));*/
		String header = mip.getMemberVerifyElement().getText();
		boolean verify = header.contains(firstName);
		Assert.assertEquals(verify, true);	
		}
	
	@Test
	public void createContribution() throws EncryptedDocumentException, IOException
	{
		String memberType = elib.getDataFromExcel("members1", 1, 1);
		String natureOfMember = elib.getDataFromExcel("members1", 1, 2);
		String companyName = elib.getDataFromExcel("members1", 1, 3);
		String title = elib.getDataFromExcel("members1", 1, 4);
		String lastName = elib.getDataFromExcel("members1", 1, 5)+jlib.getRandomNumber();
		String firstName = elib.getDataFromExcel("members1", 1, 6)+jlib.getRandomNumber();
		//System.out.println(memberType);
		
		HomePage hp=new HomePage(driver);
		hp.getMembersLink().click();
		
		MembersPage mp=new MembersPage(driver);
		mp.getNewMemberLink().click();
		
		NewMemberPage nmp=new NewMemberPage(driver);
		nmp.getMemberTypeDD().click();
		
		driver.findElement(By.xpath("//li[text()='"+memberType+"']")).click();
		
		nmp.getNatureOfMemberDD().click();
		
		driver.findElement(By.xpath("//li[text()='"+natureOfMember+"']")).click();
		
		nmp.getLastNameEdit().sendKeys(lastName);
		nmp.getFirstNameEdit().sendKeys(firstName);
		
		nmp.getSaveBtn().click();
		
		MemberInfoPage mip=new MemberInfoPage(driver);
		/*driver.findElement(By.xpath("//div[text()='"+lastName+" "+firstName+" ']"));*/
		String header = mip.getMemberVerifyElement().getText();
	
		boolean verify = header.contains(firstName);
		Assert.assertEquals(verify, true);
		
		String memberRefId="";
		for(int i=0;i<header.length();i++)
		{
			if(Character.isDigit(header.charAt(i)))
			{
				memberRefId=memberRefId+header.charAt(i);
			}
			else
			{
				break;
			}
			
		}
		
		mp.getDraftMembersLink().click();
		mp.getMemberSerachField().sendKeys(memberRefId);
		mp.getMemberSerachField().sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//span[text()='"+memberRefId+"']")).click();
		mip.validate(driver);
		
		mp.getValidatedMembersLink().click();
		mp.getMemberSerachField().sendKeys(memberRefId);
		mp.getMemberSerachField().sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='"+memberRefId+"']")).click();
		mip.getContributionsTab().click();
		mip.confirmContribution(driver, "2000", "15", "Apr", "2026");
		
		mp.getUpToDateLink().click();
		mp.getMemberSerachField().sendKeys(memberRefId);
		mp.getMemberSerachField().sendKeys(Keys.ENTER);
		
		boolean verifyUpToDateMember = driver.findElement(By.xpath("//span[text()='"+memberRefId+"']")).isDisplayed();
		Assert.assertEquals(verifyUpToDateMember, true);
	}
	
}
