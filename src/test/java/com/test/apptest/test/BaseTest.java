package com.test.apptest.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(com.test.apptest.util.TestListeners.class)
public class BaseTest {
	public WebDriver driver;
	/*public ExtentReports extent;
	public ExtentTest test;*/
	
	@Parameters("browser")
	@BeforeClass
	public void launchApp(String browser)
	{
		 /*if(browser.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", "browserDriver\\geckodriver.exe");
			  driver = new FirefoxDriver();
		 
		  // If browser is IE, then do this	  
		 
		  }
		 
		 else if(browser.equalsIgnoreCase("internetexplorer"))
		 {
			 System.setProperty("webdriver.ie.driver","browserDriver\\IEDriverServer.exe");	
			 driver=new InternetExplorerDriver();
			 
		 }*/
		 
		 if (browser.equalsIgnoreCase("Chrome")) 
		 { 
		 
			  // Here I am setting up the path for my IEDriver
		 
			  System.setProperty("webdriver.chrome.driver", "browserDriver\\chromedriver.exe");
		 
			  driver = new ChromeDriver();
		 
		  } 
		driver.get("https://www.tripadvisor.in/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*extent= new ExtentReports("D:\\ExtentReport.html", true);
		extent.loadConfig(new File("C:\\Users\\praveenkumar.dm\\QASWorkspace1\\apptest\\extent-config.xml"));
		test = extent.startTest(com.test.apptest.test.BaseTest.class.getName());
		 test.log(LogStatus.PASS, "Browser launched successfully");*/
		 
		 
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	/*	extent.endTest(test);
		extent.flush();
		extent.close();*/
	}


}
