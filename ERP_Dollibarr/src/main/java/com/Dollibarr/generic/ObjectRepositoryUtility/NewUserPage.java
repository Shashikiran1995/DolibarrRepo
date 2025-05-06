package com.Dollibarr.generic.ObjectRepositoryUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dollibarr.generic.FileUtility.ExcelUtility;

public class NewUserPage 
{
	WebDriver driver;
	public NewUserPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(id="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(id="login")
	private WebElement loginEdit;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordEdit;
	
	@FindBy(name="save")
	private WebElement saveBtn;

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getLoginEdit() {
		return loginEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	ExcelUtility elib=new ExcelUtility();
	public String createUserWithMandatoryFileds(String lastName,String loginName,int row,int colName) throws EncryptedDocumentException, IOException
	{
		HomePage hp=new HomePage(driver);
		hp.getUsersAndGroupsLink().click();
		
		UsersAndGroupsPage ugp=new UsersAndGroupsPage(driver);
		ugp.getNewUserLink().click();
		
		NewUserPage nup=new NewUserPage(driver);
		nup.getLastNameEdit().sendKeys(lastName);
		nup.getLoginEdit().click();
		nup.getLoginEdit().clear();
		nup.getLoginEdit().sendKeys(loginName);
		
		String password = nup.getPasswordEdit().getDomAttribute("value");	
		elib.setDataIntoExcel("users", row, colName, password);
		nup.getSaveBtn().click();
		return password;
	}
}
