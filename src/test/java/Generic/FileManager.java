package Generic;

import java.io.FileInputStream;
import java.util.Properties;



public class FileManager {
	Properties pro;
	public FileManager()
	{
		try
		{
			FileInputStream fis=new FileInputStream("./configuration.properties");
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Property file not found");
		}
	}
	public String getFlipkartURL()
	{
		String url= pro.getProperty("flipkart");
		if(url==null)
			throw new RuntimeException("URL is not found");
		return url;
	}
	
	public String getAmazonURL()
	{
		String url= pro.getProperty("amazon");
		if(url==null)
			throw new RuntimeException("URL is not found");
		return url;
	}
	
	public String getMyntraURL()
	{
		String url= pro.getProperty("myntra");
		if(url==null)
			throw new RuntimeException("URL is not found");
		return url;
	}
	
	public String getFacebookURL()
	{
		String url= pro.getProperty("facebook");
		if(url==null)
			throw new RuntimeException("URL is not found");
		return url;
	}
	
	
	public String getApplicationUrl()
	{
		String url = pro.getProperty("url");
		if(url==null)
		{
			throw new RuntimeException("invalid url");
		}
		return url;
		
	}
	
	public long getImplicityWait()
	{
		String implicitlywait = pro.getProperty("iw");
		if(implicitlywait==null)
		{
			throw new RuntimeException("invalid time");
		}
		return Long.parseLong(implicitlywait);
	
	}
	
	public String gerProductionUrl()
	{
		String uatURl = pro.getProperty("uaturl");
		if(uatURl==null)
		{
			throw new RuntimeException("invalid prod url");
		}
		return uatURl;
	}
}
