package com.test.apptest.test;

import org.testng.annotations.Test;

import com.test.apptest.pages.FlightSearchResultPage;
import com.test.apptest.pages.KayakHomePage;


public class Testkayak extends BaseTest {

	@Test
	public void testKayakApp() throws InterruptedException
	{
	
		KayakHomePage page= new KayakHomePage(driver);
		page.selectMainCategory("Flights");
		page.selectTripType("One-way");
		page.selectFromCity("Bengaluru");
		page.selectToCity("Pune");
		page.datePickerByDate("28");
		page.getFindHotel().click();
		Thread.sleep(5000);
		FlightSearchResultPage result= new FlightSearchResultPage(driver);
		result.getSourceCity();
		result.getDescCity();
		result.clickViewDeal();
		Thread.sleep(5000);		

	}
	
}
