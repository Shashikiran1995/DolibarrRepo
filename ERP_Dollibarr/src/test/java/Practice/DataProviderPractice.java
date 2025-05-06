package Practice;

import java.util.Base64;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dollibarr.BaseUtility.BaseClass;
import com.Dollibarr.generic.FileUtility.ExcelUtility;

public class DataProviderPractice
{
	
	@Test(dataProvider = "data")
	public void content(String count,String Count2,String Count3,String Count4,String Count5,String Count6,String Count7)
	{
		System.out.println(count +" "+Count2);
	}
	@DataProvider
	public Object[][] data() throws Exception
	{
		ExcelUtility elib=new ExcelUtility();
		int rowCount = elib.getLastRowNum("Sheet1");
		short cellCount = elib.getLastCellNum("Sheet1", 0);
		System.out.println(rowCount);
		Object[][] objarr=new Object[rowCount+1][cellCount];
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++) {
			objarr[i][j]=elib.getDataFromExcel("Sheet1", i, j);
			
			}
		}
		return objarr;
	}
}
