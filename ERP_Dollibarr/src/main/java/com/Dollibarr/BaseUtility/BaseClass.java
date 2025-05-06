package com.Dollibarr.BaseUtility;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Dollibarr.generic.DatabaseUtility.DatabaseUtility;
import com.Dollibarr.generic.FileUtility.ExcelUtility;
import com.Dollibarr.generic.FileUtility.FileUtility;
import com.Dollibarr.generic.ObjectRepositoryUtility.HomePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.LoginPage;
import com.Dollibarr.generic.WebDriverUtility.JavaUtility;
import com.Dollibarr.generic.WebDriverUtility.UtilityClassObject;
import com.Dollibarr.generic.WebDriverUtility.WebDriverUtility;




public class BaseClass 
{
	public WebDriver driver=null;
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public DatabaseUtility dlib=new DatabaseUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void configBS()
	{
	dlib.getDbconnection();
	System.out.println("======connect to Database========");
	}
	
	@BeforeClass
	public void configBC() throws IOException
	{
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		UtilityClassObject.setDriver(driver);
		System.out.println("======launch the browser=====");
	}
//	@Parameters("BROWSER")
//	@BeforeClass
//	public void configBC(String browser)
//	{
//		System.out.println("======launch the browser=====");
//		String BROWSER=browser;
//		if(BROWSER.equals("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else if(BROWSER.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
//	}
	
	@BeforeMethod
	public void configBM() throws IOException
	{
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		driver.get(URL);
		wlib.implicitWait(driver);
		wlib.maximize(driver);
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("=======login to app=====");
	}
	
	@AfterMethod
	public void confiAM()
	{
		HomePage hp=new HomePage(driver);
		hp.logout();
		System.out.println("=====logout from app=====");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("=====close the browser=====");
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS()
	{
	System.out.println("======disconnect from Database========");
	dlib.closeDbConnection();
	}

}
