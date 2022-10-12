package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObject.AddcustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class Steps extends BaseClass {
	
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System. setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		lp=new LoginPage(driver);//creating loginpage object to access login page elements
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url ) {
	   
	    driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
	   lp.setUserName(username);
	   lp.setPassword(password);
	   
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	   
	    lp.clickLogin();
	    Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }
	    else {
	    	Assert.assertEquals(title,driver.getTitle());
	    }
	    Thread.sleep(3000);
	}

	@When("User click on Log out Link")
	public void user_click_on_log_out_link() throws InterruptedException {
	    
	    lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	    
	}
	
	//Customer feature step definitions.............................................
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		
		addCust=new AddcustomerPage(driver); 
		
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle()); 
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
	  Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnAddNew();
	   
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
				
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email=randomeString()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("abc@98765");
		addCust.setFirstName("cucumber");
		addCust.setLastName("Training");
		addCust.setGender("Female");
		addCust.setDateOfBirth("02/02/1990");
		addCust.setCompanyName("traning company");
		addCust.checkIsTaxExempted();
		addCust.setNewsLetter("Test store 2");
		addCust.selectManagerOfVendor("Vendor 1");
		addCust.setAdminComment("creating a customer for only traing purpose");
	    
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		
		addCust.clickOnSave();
		Thread.sleep(2000);
	    
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	    
	}
	
	//steps for searching customer by email
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		
		searchcust=new SearchCustomerPage(driver);
		
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Search button")
	public void click_on_search_button() throws InterruptedException {
	    searchcust.clickSearch();
	    Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() 
	{
	   boolean status= searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	   
	   Assert.assertEquals(true, status);
	}
	
	//steps for searching customer by name
	
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		
		searchcust=new SearchCustomerPage(driver);
	    searchcust.setFirstName("cucumber");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchcust.setLastName("Training");
	    
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		
		boolean status=searchcust.searchCustomerByName("cucumber" ,"Training");
		Assert.assertEquals(true, status);
	    
	}
}
