package com.Dollibarr.generic.ObjectRepositoryUtility;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dollibarr.generic.WebDriverUtility.WebDriverUtility;

public class NewPurchaseOrderPage 
{
	WebDriver driver;
	public NewPurchaseOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@title='Select a third party']")
	private WebElement selectThirdPartyDD;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement selectThirdPartySearchField;
	
	@FindBy(xpath="//td[text()='Payment Terms']/..//span[@class='select2-selection__rendered']")
	private WebElement paymentTermsDD;
	
	@FindBy(className ="select2-search__field")
	private WebElement paymentTermsSearchField;
	
	@FindBy(xpath="//td[text()='Payment method']/following-sibling::td//span[@class='select2-selection__rendered']")
	private WebElement paymentModeDD;
	
	@FindBy(className ="select2-search__field")
	private WebElement paymentModeSearchField;
	
	@FindBy(className ="ui-datepicker-trigger")
	private WebElement SelectDateBtn;
	
	@FindBy(className ="ui-datepicker-year")
	private WebElement yearDD;
	
	@FindBy(className ="ui-datepicker-month")
	private WebElement monthDD;
	
	@FindBy(name="save")
	private WebElement saveBtn;
	
	public WebElement getPaymentTermsDD() {
		return paymentTermsDD;
	}

	public WebElement getPaymentTermsSearchField() {
		return paymentTermsSearchField;
	}

	public WebElement getPaymentModeDD() {
		return paymentModeDD;
	}

	public WebElement getPaymentModeSearchField() {
		return paymentModeSearchField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSelectThirdPartyDD() {
		return selectThirdPartyDD;
	}

	public WebElement getSelectThirdPartySearchField() {
		return selectThirdPartySearchField;
	}
	
	
	public WebElement getSelectDateBtn() {
		return SelectDateBtn;
	}

	public WebElement getYearDD() {
		return yearDD;
	}

	public WebElement getMonthDD() {
		return monthDD;
	}

	public WebDriverUtility getWlib() {
		return wlib;
	}

	WebDriverUtility wlib=new WebDriverUtility();
	public void selectDate(WebDriver driver, String date,String month,String year)
	{
		/*
		 * provide driver instance along with date ,month, year
		 */
		SelectDateBtn.click();
		wlib.selectByVisibleText(yearDD, year);
		wlib.selectByVisibleText(monthDD, month);
		driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
		
	}
	
}
