package com.test.apptest.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(com.test.apptest.util.TestListeners.class)
public class BaseTest {
	public WebDriver driver;	
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
		 
			  System.setProperty("webdriver.chrome.driver", "browserDriver\\chromedriver.exe");
		 	  driver = new ChromeDriver();
		 
		 } 
		driver.get("https://www.tripadvisor.in/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();	
	}

}
