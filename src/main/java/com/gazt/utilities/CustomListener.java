package com.gazt.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.gazt.extentreports.ExtentReportManager;
import com.gazt.testbase.TestBase;

public class CustomListener extends TestBase implements ITestListener
{
    //Extent Report Declarations
    private static ExtentReports extent = ExtentReportManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
        System.out.println((result.getMethod().getMethodName() + " STARTED!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);;
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+" PASSED!");
		test.get().pass("Test Passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
		captureScreenShot(methodname);
        System.out.println(methodname+ "...FAILED!");
        test.get().fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
        System.out.println((result.getMethod().getMethodName() + "...SKIPPED!"));
        test.get().skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Extent Reports Version 3 Test Suite started!");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
	}

}
