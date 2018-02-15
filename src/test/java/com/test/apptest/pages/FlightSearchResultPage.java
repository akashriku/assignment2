package com.test.apptest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.apptest.bean.CityBean;

public class FlightSearchResultPage {
	
	public WebDriver driver;
	
	@FindAll({@FindBy(xpath="//div[@class='departureDescription airportDescription']")}) private List<WebElement> sourceCity;
	@FindAll({@FindBy(xpath="//div[@class='arrivalDescription airportDescription']")}) private List<WebElement> desCity;
	@FindAll({@FindBy(xpath="//span[@class='ui_button original chevron w100p viewDealButton']")}) private List<WebElement> viewDeal;
	@FindAll({@FindBy(xpath="//span[@class='deeplinkPrice']")}) private List<WebElement> priceList;
	
	
	
	public FlightSearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void getSourceCity() throws InterruptedException
	{
		Thread.sleep(2000);	
		if(driver.getWindowHandles().size()>0)
		{
			for(String handle:driver.getWindowHandles())
			{
				driver.switchTo().window(handle);
			}
		}
			Assert.assertEquals(sourceCity.get(0).getText().contains(CityBean.getSourceCity()),true);
	}
	
	public void getDescCity()
	{
		
			Assert.assertEquals(desCity.get(0).getText().contains(CityBean.getDestCity()),true);
	}
	public void clickViewDeal()
	{
		viewDeal.get(0).click();
	}
}
