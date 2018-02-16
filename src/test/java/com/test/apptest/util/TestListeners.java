package com.test.apptest.util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	 public WebDriver driver;
	
	public void onFinish(ITestContext result) {
		
		System.out.println("the result on the finish of the execution :-"+result.getName());
	}

	public void onStart(ITestContext result) {
		System.out.println("the result on the start of the test case :-"+result.getName());
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("the test failed and the success percentage is :-"+result.getTestName());
		
		
	}

	
	public void onTestFailure(ITestResult result) {
		this.driver=((com.test.apptest.test.BaseTest)result.getInstance()).driver;
		System.out.println("Following test got passed :- "+result.getName());
		
	}

	
	public void onTestSkipped(ITestResult result) {
		this.driver=((com.test.apptest.test.BaseTest)result.getInstance()).driver;
		System.out.println("Following test got passed :- "+result.getName());
		
	}

   public void onTestStart(ITestResult result) {
		System.out.println("on the start of the test case :-"+result.getName());	
	}

	public void onTestSuccess(ITestResult result) {
		this.driver=((com.test.apptest.test.BaseTest)result.getInstance()).driver;
		System.out.println("Following test got passed :- "+result.getName());
		
	}
	
}
