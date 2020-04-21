package stepDefnitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic.BrowserFactory;
import Generic.FileManager;
import POM.Flipkart_Cart_Page;
import POM.Flipkart_Fastrack_Watch1_DetailsPage;
import POM.Flipkart_Fastrack_Watch_Page;
import POM.Online_Shopping_Flipkart__Home_Page;
import POM.Online_Shopping_Flipkart__Login_Page;

public class Steps {
	WebDriver driver;
//	@Before				//Global Hooks
//	public void OpenAppn()
//	{
//		System.out.println("Chrome browser is launched");
//	}
//	@After				//Global Hooks
//	public void closeAppn(Scenario scenario)
//	{
//		if (scenario.isFailed())
//		{
//			System.out.println(scenario.getName());	
//			System.out.println("Takes Screenshot");
//		}
//		System.out.println("Chrome browser is closed");
//
//	}
	
//	@Before	(order=1)			//Local Hooks
//	public void Localhook()
//	{
//		System.out.println("Before-Local hook=1");
//	}
//	@After(order=1)				//Local Hooks
//	public void Localhooks()
//	{
//	System.out.println("After-Local hook=1");
//	}
//	
//	@Before	(order=2)			//Local Hooks
//	public void Localhook2()
//	{
//		System.out.println("Before-Local hook=2");
//	}
//	@After(order=2)				//Local Hooks
//	public void Localhooks2()
//	{
//	System.out.println("After-Local hook=2");
//	}

	@Given("user is on Login Page")
	public void user_is_on_Login_Page() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost/login.do");
		//System.out.println("Thread-id is "+ Thread.currentThread().getId());
	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String uname, String password) {
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.name("pwd")).sendKeys(password);
	}

	@When("clicks on remember me checkbox")
	public void clicks_on_remember_me_checkbox() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("keepLoggedInCheckBox")).click(); 
	}

	@When("clicks on Login button")
	public void clicks_on_Login_button() {
		{
			driver.findElement(By.xpath("//div[.='Login ']")).click();
		}
	}

	@Then("Message dispalyed Login Successfully {string}")
	public void message_dispalyed_Login_Successfully(String expected_result) throws InterruptedException {
		Thread.sleep(2000);
		String atitle = driver.getTitle();
		System.out.println(atitle);
		Assert.assertEquals(expected_result,atitle);
		driver.quit();
	}

	@When("user enters valid Username {string} and Password {string}")
	public void user_enters_valid_Username_and_Password(String string, String string2) {
		driver.findElement(By.id("username")).sendKeys(string);
		driver.findElement(By.name("pwd")).sendKeys(string2);
	}

	@Then("Error message dispalyed")
	public void error_message_dispalyed() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.className("errormsg")).isDisplayed();
		String atitle = driver.getTitle();
		System.out.println(atitle);
		Assert.assertEquals("actiTIME - Login",atitle);
		Thread.sleep(2000);
		driver.quit();
	}


	//@Shopping_page-data-table

	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("User is on home page");
	}

	@When("user search for product")
	public void user_search_for_product(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class) ;  //Type keyType,Type valueType
		String pro = data.get(0).get("product");
		String qty = data.get(0).get("quantity");
		String pro1 = data.get(1).get("product");
		String qty1 = data.get(1).get("quantity");
		String pro2 = data.get(2).get("product");
		String qty2 = data.get(2).get("quantity");
		System.out.println(pro+" - "+qty);
		System.out.println(pro1+" - "+qty1);
		System.out.println(pro2+" - "+qty2);
	}

	@Then("product page should be displayed")
	public void product_page_should_be_displayed() {
		System.out.println("Respective product page will be displayed");
	}
	
	
	
	//-------------------------Flipkart Scenario---------------------------//
	
	
	FileManager fm = new FileManager();
	BrowserFactory bff = new BrowserFactory();

	@Before(order=0)
	public void setUp() {
		// driver=new BrowserFactory().getBrowser("chrome");
		driver = bff.getBrowser("chrome");
		driver.get(fm.getFlipkartURL());
		
	}
	
	@After(order=0)
	public void tearDown(Scenario scenario)// global hooks
	{
		if (scenario.isFailed())// class that is responsible to get status of scenarios
		{
			System.out.println();
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

			scenario.embed(screenshot, "Image/PNG", scenario.getName());

		}
		driver.quit();
	}
	
	@Given("User is on Flipkart login page and enter valid {string} and {string}")
	public void user_is_on_Flipkart_login_page_and_enter_valid_and(String email, String pwd) throws InterruptedException {
	  System.out.println("Flipkart Login page is displayed");
	  Online_Shopping_Flipkart__Login_Page lp=new Online_Shopping_Flipkart__Login_Page(driver);
	  lp.setMailid(email);
	  lp.setPassword(pwd);
	  lp.clickLogin();
	  Thread.sleep(3000);
	  
	}

	@When("User is on Home page")
	public void user_is_on_Home_page() throws InterruptedException {
		System.out.println("Flipkart Home is dispalyed");
		Online_Shopping_Flipkart__Home_Page hp=new Online_Shopping_Flipkart__Home_Page(driver);
		hp.Men_mousehover();
		Thread.sleep(3000);
		hp.Fastrack_Click();
	}

	@When("User is Product list page")
	public void user_is_Product_list_page() {
		System.out.println("Product list page is displayed");
		Flipkart_Fastrack_Watch_Page list=new Flipkart_Fastrack_Watch_Page(driver);
		list.ClickWatch2();
	}

//	@When("User is on Product details page")
//	public void user_is_on_Product_details_page() {
//		System.out.println("Product details page is dispalyed");
//		Flipkart_Fastrack_Watch1_DetailsPage pp=new Flipkart_Fastrack_Watch1_DetailsPage(driver);
//		pp.Click_Add2cart();
//	}
//
//	@Then("User is on Cart page")
//	public void user_is_on_Cart_page() {
//		System.out.println("Cart page is displayed");
//		Flipkart_Cart_Page cp=new Flipkart_Cart_Page(driver);
//		cp.Click_Remove();
//		cp.Click_Remove2();
//		cp.verify_cart_empty();
//	}

}
