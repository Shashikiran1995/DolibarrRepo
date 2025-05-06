package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dollibarr.generic.WebDriverUtility.WebDriverUtility;

public class NewMemberPage extends MembersPage
{
	
    WebDriver driver;
	public NewMemberPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
    
	@FindBy(id="select2-typeid-container")
    private WebElement memberTypeEdit;
	
	@FindBy(id="select2-morphy-container")
	private WebElement natureOfMemberDD;
	
	@FindBy(xpath="//input[@name='societe']")
	private WebElement companyEdit;
	
	@FindBy(id="select2-civility_id-container")
	private WebElement titleDD;
	
	@FindBy(name="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(name="firstname")
	private WebElement firstNameEdit;
	
	@FindBy(name="save")
	private WebElement saveBtn;
	
	@FindBy(xpath="//li[text()='Companies']")
	private WebElement memberTypeCompanies;
	
	@FindBy(xpath="//li[text()='Individuals']")
	private WebElement memberTypeIndividuals;

	@FindBy(xpath="//li[text()='bank']")
	private WebElement memberTypebank;
	
	@FindBy(xpath="//li[text()='Individual']")
	private WebElement natureOfMemberIndividual;
	
	@FindBy(xpath="//li[text()='Corporation']")
	private WebElement natureOfMemberCorporation;
	
	@FindBy(xpath="//img[@class='ui-datepicker-trigger']")
	private WebElement dateOfBirthCalender;
	
	@FindBy(className ="ui-datepicker-year")
	private WebElement yearDD;
	
	@FindBy(className ="ui-datepicker-month")
	private WebElement monthDD;
	
	@FindBy(id="select2-gender-container")
	private WebElement genderDD;
	
	@FindBy(name="member_email")
	private WebElement emailEdit;
	
	@FindBy(id="member_url")
	private WebElement webEdit;
	
	@FindBy(name="address")
	private WebElement addressEdit;
	
	@FindBy(id="zipcode")
	private WebElement zipCodeEdit;
	
	@FindBy(id="town")
	private WebElement cityEdit;
	
	@FindBy(id="select2-selectcountry_id-container")
	private WebElement countryEdit;
	
	@FindBy(id="select2-state_id-container")
	private WebElement stateEdit;
	
	@FindBy(name="phone")
	private WebElement bPhoneEdit;
	
	@FindBy(name="phone_perso")
	private WebElement pPhoneEdit;
	
	@FindBy(name="phone_mobile")
	private WebElement mPhoneEdit;
	
	@FindBy(id="public")
	private WebElement publicSelectDD;
	
	public WebElement getDateOfBirthCalender() {
		return dateOfBirthCalender;
	}

	public WebElement getMemberTypeDD() {
		return memberTypeEdit;
	}

	public WebElement getNatureOfMemberDD() {
		return natureOfMemberDD;
	}

	public WebElement getCompanyEdit() {
		return companyEdit;
	}

	public WebElement getTitleDD() {
		return titleDD;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getFirstNameEdit() {
		return firstNameEdit;
	}

	public WebElement getGenderDD() {
		return genderDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getMemberTypeCompanies() {
		return memberTypeCompanies;
	}

	public WebElement getMemberTypeIndividuals() {
		return memberTypeIndividuals;
	}

	public WebElement getMemberTypebank() {
		return memberTypebank;
	}

	public WebElement getNatureOfMemberIndividual() {
		return natureOfMemberIndividual;
	}

	public WebElement getNatureOfMemberCorporation() {
		return natureOfMemberCorporation;
	}
	
	
	public WebElement getEmailEdit() {
		return emailEdit;
	}

	public WebElement getWebEdit() {
		return webEdit;
	}

	public WebElement getAddressEdit() {
		return addressEdit;
	}

	
	public WebElement getZipCodeEdit() {
		return zipCodeEdit;
	}

	public WebElement getCityEdit() {
		return cityEdit;
	}

	public WebElement getCountryEdit() {
		return countryEdit;
	}

	public WebElement getStateEdit() {
		return stateEdit;
	}

	
	public WebElement getbPhoneEdit() {
		return bPhoneEdit;
	}

	public WebElement getpPhoneEdit() {
		return pPhoneEdit;
	}

	public WebElement getmPhoneEdit() {
		return mPhoneEdit;
	}

	public WebElement getPublicSelectDD() {
		return publicSelectDD;
	}

	WebDriverUtility wlib=new WebDriverUtility();
	public void selectDate(WebDriver driver, String date,String month,String year)
	{
		/*
		 * provide driver instance along with date ,month, year
		 */
		dateOfBirthCalender.click();
		wlib.selectByVisibleText(yearDD, year);
		wlib.selectByVisibleText(monthDD, month);
		driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
		
	}
	
}
