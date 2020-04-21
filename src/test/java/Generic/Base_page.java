package Generic;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public abstract class Base_page {
	public WebDriver driver;
	public Base_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public void verify_Visibility( int time,WebElement element)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.visibilityOf(element));
	System.out.println("Element is located");
}
catch(Exception e)
{
	System.out.println("Failed to Locate Element");	
	Assert.fail();
}
}

public void verify_Click( int time,WebElement element)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.elementToBeClickable(element));
	System.out.println("Element is clicked");
}
catch(Exception e)
{
	System.out.println("Failed to Click Element");
	Assert.fail();
}
}

public void verify_Title( int time,String title)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.titleContains(title));
	System.out.println("Title is dispalyed");
}
catch(Exception e)
{
	System.out.println("Title mismatch");
	Assert.fail();
}
}

public void verify_ElementLocation( int time,By xpath)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.presenceOfElementLocated(xpath));	
	System.out.println("Located element is found");
}
catch(Exception e)
{
	System.out.println("Failed to find located element");
	Assert.fail();
}
}

public void verify_NoOfWindows(int time,int expectedNumberOfWindows)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
	System.out.println("Loaded new window");
}
catch(Exception e)
{
	System.out.println("Failed to load new window");	
	Assert.fail();
}
}
}


