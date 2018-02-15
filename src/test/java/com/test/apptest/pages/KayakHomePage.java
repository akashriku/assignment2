package com.test.apptest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.apptest.bean.CityBean;
import com.test.apptest.test.BaseTest;


public class KayakHomePage extends BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath="(//input[@value='Mumbai, India - Chhatrapati Shivaji (BOM)'])[2]")private WebElement fromCity;
	@FindAll({@FindBy(xpath="//li[contains(@class,'ui_icon flights')]")}) private List<WebElement> citySuggestions;
	@FindBy(xpath="(//input[@placeholder='City or Airport'])[4]")private WebElement toCity;
	@FindBy(id="ow_ui_picker") private WebElement dateSelection;
	@FindBy(xpath="(//span[text()='Find flights '])[2]") private WebElement findHotelButton;
	@FindBy(xpath="//li[contains(@class,'ui_icon flights')]/div")private WebElement cityCode;
	
	
	
	public KayakHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	public void selectMainCategory(String menu)
	{
		driver.findElement(By.xpath("//a[text()='"+menu+"']")).click();     
	}
	public void selectTripType(String trip)
	{
		driver.findElement(By.xpath("//a[text()='"+trip+"']")).click();
	}
	public void selectFromCity(String sourceCity) throws InterruptedException
	{
		Thread.sleep(5000);
		
		fromCity.click();
		fromCity.clear();
		fromCity.sendKeys(sourceCity);
		for(WebElement c:citySuggestions)
		{
			if(c.getText().contains(sourceCity))
			{
				String s=cityCode.getText();
				CityBean.setSourceCity(s.substring(s.length()-4,s.length()-1));
				c.click();
				break;
			}
		}
		
	}
	
	public void selectToCity(String destinationCity)
	{
		toCity.clear();
		toCity.sendKeys(destinationCity);
		for(WebElement c:citySuggestions)
		{
			if(c.getText().contains(destinationCity))
			{
				String s=cityCode.getText();
				CityBean.setDestCity(s.substring(s.length()-4,s.length()-1));
				c.click();
				break;
			}
		}
	}
	
	public void datePickerByDate(String date)
	{
		dateSelection.click();
		 try {
			 driver.findElement(By.xpath("//span[text()="+date+"]")).click();  
	          } catch (AssertionError Ae) {
	            Ae.printStackTrace();
	        }
	}
	
	public WebElement getFindHotel() {
		return findHotelButton;
		
		
	}
	
	
	
}
