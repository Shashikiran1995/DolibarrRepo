package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dollibarr.generic.WebDriverUtility.WebDriverUtility;

public class NewLeavePage 
{
	WebDriver driver;
	public NewLeavePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="select2-type-container")
	private WebElement typeOfLeaveDD;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement typeOfLeaveSearchField;
	
	@FindBy(xpath="//div[@class='nowraponall inline-block divfordateinput']/input[@id='date_debut_']/following-sibling::img")
	private WebElement startDateCalender;

	@FindBy(xpath="//div[@class='nowraponall inline-block divfordateinput']/input[@id='date_fin_']/following-sibling::img")
	private WebElement EndDateCalender;
	
	@FindBy(className="ui-datepicker-month")
	private WebElement monthDD;
	
	@FindBy(className="ui-datepicker-year")
	private WebElement yearDD;
	
	@FindBy(xpath="//span[@id='select2-valideur-container']")
	private WebElement approverDD;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement appoverSearchField;
	
	@FindBy(name="save")
	private WebElement saveBtn;
	
	public WebElement getTypeOfLeaveDD() {
		return typeOfLeaveDD;
	}

	public WebElement getStartDateCalender() {
		return startDateCalender;
	}

	public WebElement getEndDateCalender() {
		return EndDateCalender;
	}

	public WebElement getMonthDD() {
		return monthDD;
	}

	public WebElement getYearDD() {
		return yearDD;
	}
	
	public WebElement getApproverDD() {
		return approverDD;
	}

	public WebElement getAppoverSearchField() {
		return appoverSearchField;
	}

	
	public WebElement getTypeOfLeaveSearchField() {
		return typeOfLeaveSearchField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	WebDriverUtility wlib=new WebDriverUtility();
	public void selectStartDate(WebDriver driver,String day,String month,String year)
	{
		/*
		 * provide driver instance along with date ,month, year
		 */
		startDateCalender.click();
		wlib.selectByVisibleText(monthDD, month);
		wlib.selectByVisibleText(yearDD, year);
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}
	
	public void selectEndDate(WebDriver driver,String day,String month,String year)
	{
		/*
		 * provide driver instance along with date ,month, year
		 */
		EndDateCalender.click();
		wlib.selectByVisibleText(monthDD, month);
		wlib.selectByVisibleText(yearDD, year);
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}
}
