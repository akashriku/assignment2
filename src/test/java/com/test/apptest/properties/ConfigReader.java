package com.test.apptest.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	
	public ConfigReader() 
	{
		
		try 
		{
			File src=new File("./configuration/config.property");
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("the exception is"+e.getMessage());
		}		
	}
	public String getUrl()
	{
		String url=prop.getProperty("URL");
		return url;	
	}
		
	
	
}
