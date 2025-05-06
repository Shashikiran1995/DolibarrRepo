package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercePage 
{
	WebDriver driver;	
	public CommercePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Purchase orders']/../..//a[@title='New order']")
	private WebElement newPurchaseOrderLink;
	
	@FindBy(xpath="//a[@title='Purchase orders']/../..//a[@title='List']")
	private WebElement listOfPurchaseOrders;
	
	@FindBy(xpath="//a[@title='Purchase orders']/../..//a[@title='Draft']")
	private WebElement draftOfPurchaseOrders;
	
	@FindBy(xpath="//a[@title='Purchase orders']/../..//a[@title='Approved']")
	private WebElement approvedOrders;
	
	@FindBy(name="search_ref")
	private WebElement searchOfPurchaseOrder;
	
	public WebElement getNewPurchaseOrderLink() {
		return newPurchaseOrderLink;
	}

	public WebElement getListOfPurchaseOrders() {
		return listOfPurchaseOrders;
	}

	public WebElement getDraftOfPurchaseOrders() {
		return draftOfPurchaseOrders;
	}

	public WebElement getSearchOfPurchaseOrder() {
		return searchOfPurchaseOrder;
	}

	public WebElement getApprovedOrders() {
		return approvedOrders;
	}
	
	
	
}
