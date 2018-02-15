package com.test.apptest.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	 public WebDriver driver;
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		this.driver=((com.test.apptest.test.BaseTest)arg0.getInstance()).driver;
		System.out.println("Following test got passed : "+arg0.getName());
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\praveenkumar.dm\\QASWorkspace1\\apptest\\ScreenShots"+timeStamp+".png"));
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		this.driver=((com.test.apptest.test.BaseTest)arg0.getInstance()).driver;
		System.out.println("Following test got passed : "+arg0.getName());
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\praveenkumar.dm\\QASWorkspace1\\apptest\\ScreenShots"+timeStamp+".png"));
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		this.driver=((com.test.apptest.test.BaseTest)arg0.getInstance()).driver;
		System.out.println("Following test got passed : "+arg0.getName());
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\praveenkumar.dm\\QASWorkspace1\\apptest\\ScreenShots\\"+timeStamp+".png"));
		
	}
	
	

}
