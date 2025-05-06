package com.Dollibarr.generic.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplimentation implements IRetryAnalyzer
{
	int count=0;
	int actCount=3;
	@Override
	public boolean retry(ITestResult result) 
	{
	   if(count<actCount) 
	   {
		   count++;
		   return true;
	   }	
		
		return false;
	}

}
