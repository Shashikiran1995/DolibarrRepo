package com.Dollibarr.generic.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Dollibarr.generic.WebDriverUtility.UtilityClassObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener,ISuiteListener
{
	public ExtentReports report;
	public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		String date = new Date().toString().replaceAll(" ", "_").replaceAll(":", "-");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceRepots/report"+" "+date+".html");
		spark.config().setDocumentTitle("ERP Dollibarr Suite Report");
		spark.config().setReportName("Dollibarr Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows 11");
		report.setSystemInfo("browser", "chrome 133");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"=======> Test started<======");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName()+"=======> Test started<======");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"=======> Test Success <=======");
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName()+"=======> Test Success <=======");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"=======> Test Failed <=======");
		String methodName = result.getMethod().getMethodName();
		String date = new Date().toString().replaceAll(" ", "_").replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot) UtilityClassObject.getDriver();
		String src = ts.getScreenshotAs(OutputType.BASE64);
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(src, methodName+"_"+date);
		
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName()+"=======> Test Failed<======");
		UtilityClassObject.getTest().info(MarkupHelper.createLabel("FAIL", ExtentColor.RED));
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
}
