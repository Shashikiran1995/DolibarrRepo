package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Dollibarr.generic.FileUtility.ExcelUtility;
import com.Dollibarr.generic.FileUtility.FileUtility;
import com.Dollibarr.generic.ObjectRepositoryUtility.HomePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.LoginPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewMemberPage;
import com.Dollibarr.generic.WebDriverUtility.JavaUtility;
import com.Dollibarr.generic.WebDriverUtility.WebDriverUtility;

public class Create_Member_As_Individual 
{
public static void main(String[] args) throws IOException 
{
	FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	ExcelUtility elib=new ExcelUtility();
	
	String BROWSER = flib.getDataFromPropertiesFile("browser");
	String URL = flib.getDataFromPropertiesFile("url");
	String USERNAME = flib.getDataFromPropertiesFile("username");
	String PASSWORD = flib.getDataFromPropertiesFile("password");
	
	String memberType = elib.getDataFromExcel("members", 1, 1);
	String natureOfMember = elib.getDataFromExcel("members", 1, 2);
	String company = elib.getDataFromExcel("members", 1, 3) + jlib.getRandomNumber();
	String tiltle = elib.getDataFromExcel("members", 1, 4);
	String lastName = elib.getDataFromExcel("members", 1, 5) + jlib.getRandomNumber();
	String firstName = elib.getDataFromExcel("members", 1, 6) + jlib.getRandomNumber();
	String gender = elib.getDataFromExcel("members", 1, 7);
	
	WebDriver driver=null;
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
	
	driver.get(URL);
	wlib.maximize(driver);
	wlib.implicitWait(driver);
	
	LoginPage lp=new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);
	
	HomePage hp=new HomePage(driver);
	hp.getMembersLink().click();
	
	NewMemberPage nmp=new NewMemberPage(driver);
	nmp.getNewMemberLink().click();
	
	nmp.getMemberTypeDD().click();
	driver.findElement(By.xpath("//li[text()='"+memberType+"']")).click();
	
	nmp.getNatureOfMemberDD().click();
	driver.findElement(By.xpath("//li[text()='"+natureOfMember+"']")).click();
	
	nmp.getCompanyEdit().sendKeys(company);
	nmp.getTitleDD().click();
	driver.findElement(By.xpath("//li[text()='"+tiltle+"']")).click();
	
	nmp.getLastNameEdit().sendKeys(lastName);
	nmp.getFirstNameEdit().sendKeys(firstName);
	
	nmp.getGenderDD().click();
	driver.findElement(By.xpath("//li[text()='"+gender+"']")).click();
	
	nmp.getSaveBtn().click();
	
	nmp.getDraftMembersLink().click();
	
	WebElement companyVerify = driver.findElement(By.xpath("//td[text()='"+company+"']"));
	if(companyVerify.isDisplayed())
	{
		System.out.println(company +" company is present in draft");
	}
	else
	{
		System.out.println(company + " company is not present in draft");
	}
	driver.quit();
 }
}

