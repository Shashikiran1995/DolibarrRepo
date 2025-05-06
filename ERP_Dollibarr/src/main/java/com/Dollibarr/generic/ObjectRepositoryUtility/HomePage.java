package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Home']")
	private WebElement homeLink;
	
	@FindBy(xpath="//a[@title='Users & Groups']")
	private WebElement usersAndGroupsLink;
	
	@FindBy(xpath="//span[text()='Members']")
	private WebElement membersLink;
	
	@FindBy(xpath="//span[text()='Third-parties']")
	private WebElement thirdPartiesLink;
	
//	@FindAll({@FindBy(xpath="//span[text()='Products | Services']"),@FindBy(id="mainmenua_products")})
//	private WebElement productsServicesLink;
	
	@FindBy(xpath="//span[text()='MRP']")
	private WebElement mrpLink;
	
	@FindBy(xpath="//span[text()='Commerce']")
	private WebElement commerceLink;
	
	@FindBy(xpath="//span[text()='HRM']")
	private WebElement hrmLink;
	
	@FindBy(xpath="//span[text()='Billing | Payment']")
	private WebElement billingPaymentLink;
	
	@FindBy(xpath="//span[text()='Banks | Cash']")
	private WebElement banksCashLink;
	
	@FindBy(id="topmenu-login-dropdown")
	private WebElement profileDD;
	
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement logoutLink;
	
	public WebElement getUsersAndGroupsLink() {
		return usersAndGroupsLink;
	}
	
	public WebElement getMembersLink() {
		return membersLink;
	}
	
	public WebElement getThirdPartiesLink() {
		return thirdPartiesLink;
	}
	
//	public WebElement getProductsServicesLink() {
//		return productsServicesLink;
//	}
	
	public WebElement getMrpLink() {
		return mrpLink;
	}
	
	public WebElement getCommerceLink() {
		return commerceLink;
	}
	
	public WebElement getHrmLink() {
		return hrmLink;
	}
	
	public WebElement getBillingPaymentLink() {
		return billingPaymentLink;
	}
	
	public WebElement getBanksCashLink() {
		return banksCashLink;
	}
	
	
	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getProfileDD() {
		return profileDD;
	}

	public void logout()
	{
		profileDD.click();
		logoutLink.click();
	}
}
