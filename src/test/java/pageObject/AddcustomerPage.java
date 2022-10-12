package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {
	
	WebDriver ldriver;
	public AddcustomerPage (WebDriver rdriver)
	{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this) ;
	}
	
	
	By lnkcustomers_menu=By.xpath("//i[@class='nav-icon far fa-user']/following-sibling::p");
	By lnkCustomers_menuitem=By.xpath("//p[text()=' Customers']");
	By btnAddnew=By.xpath("//a[@class='btn btn-primary']"); //Add new
	By txtEmail=By.xpath("//input[@name='Email']");
	By txtPassword=By.xpath("//input[@name='Password']");
	By txtFirstName=By.xpath("//input[@name='FirstName']");
	By txtLastName=By.xpath("//input[@name='LastName']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");
	By txtDob=By.id("DateOfBirth");
	By txtCompany_Name=By.xpath("//input[@id='Company']");
	By chkbox_IsTxExempted=By.xpath("//input[@id='IsTaxExempt']");
	
	By txtNewsletter=By.xpath("//*[text()='Newsletter']/parent::div/parent::div/following-sibling::div/div/div/div/div");//select[@id='SelectedNewsletterSubscriptionStoreIds']
	By ListitemYourStore=By.xpath("//li[contains(text(),'Your store name')]");
	By ListitemTestStore=By.xpath("//li[contains(text(),'Test store 2')]");
	
	By txtCustomerRoles=By.xpath("//*[text()='Customer roles']/parent::div/parent::div/following-sibling::div/div/div/div/div");
	By ListitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By ListitemForumModerators=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By ListitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By ListitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By ListitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By Drp_ManagerOfVendor=By.xpath("//*[@id='VendorId']");
	By txtAdminComment=By.xpath("//textarea[@id='AdminComment']");
	By btn_save=By.xpath("//button[@name='save']");
	
	public String getPageTitle() 
	{
		return ldriver.getTitle();
		
	}
	public void clickOnCustomersMenu() {
		
		ldriver.findElement(lnkcustomers_menu).click(); 
	}
	
	public void clickOnCustomersMenuItem() {

		ldriver.findElement(lnkCustomers_menuitem).click(); 
	}
	
	public void clickOnAddNew() {

		ldriver.findElement(btnAddnew).click(); 
	}
	
	public void setEmail(String email) {

		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) {

		ldriver.findElement(txtPassword).sendKeys(password); 
	}
	
	public void setFirstName(String firstname) {

		ldriver.findElement(txtFirstName).sendKeys(firstname); 
	}
	
	public void setLastName(String lastname) {

		ldriver.findElement(txtLastName).sendKeys(lastname);
	}
	
	public void setGender(String gender) {

		if(gender.equals("Male"))
		{
		ldriver.findElement(rdMaleGender).click(); 
		}

		else if(gender.equals("Female"))
		{
		ldriver.findElement(rdFemaleGender).click(); 
		}

		else
		{
		ldriver.findElement(rdMaleGender).click(); //Default
		}
	}
	
	public void setDateOfBirth(String dob) {

		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String companyname) {

		ldriver.findElement(txtCompany_Name).sendKeys(companyname);
	}
	
	public void checkIsTaxExempted() {

		ldriver.findElement(chkbox_IsTxExempted).click();
		
	}
	
	public void setNewsLetter(String role) throws InterruptedException {
 
		//Select selectNewsLetter=new Select(ldriver.findElement(Drp_Newsletter));
		//selectNewsLetter.selectByValue(value);;
		
		if(!role.equals("Test store 2"))
		{
			ldriver.findElement(By.xpath("//*[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/li/span"));
		}
		
		ldriver.findElement(txtNewsletter).click();
		WebElement listitem;
		
		Thread.sleep(3000);
		
		if(role.equals("Test store 2")) 
		{
			listitem=ldriver.findElement(ListitemTestStore);
		}
		else 
		{
			listitem=ldriver.findElement(ListitemYourStore);
		}
	}
	

	public void setCustomerRoles(String role) throws InterruptedException {
	
		if(!role.equals("Vendors"))
		{
			ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span"));
		}
		
		ldriver.findElement(txtCustomerRoles).click();
		WebElement listitem;
		
		Thread.sleep(3000);
		
		if(role.equals("Administrators")) 
		{
			listitem=ldriver.findElement(ListitemAdministrators);
		}
		
		else if(role.equals("Forum Moderators")) 
		{
			listitem=ldriver.findElement(ListitemForumModerators);
		}
		
		else if(role.equals("Guests")) 
		{
			listitem=ldriver.findElement(ListitemGuests);
		}
		
		else if(role.equals("Registered")) 
		{
			listitem=ldriver.findElement(ListitemRegistered);
		}
		
		else if(role.equals("Vendors")) 
		{
			listitem=ldriver.findElement(ListitemVendors);
		}
		
		else 
		{
			listitem=ldriver.findElement(ListitemGuests);
		}
		
		//listitem.click();
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();",listitem);
	}
	
	public void selectManagerOfVendor(String value) {

	
		Select drp=new Select(ldriver.findElement(Drp_ManagerOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setAdminComment(String admincomment) {

		ldriver.findElement(txtAdminComment).sendKeys(admincomment);
	}
	
	public void clickOnSave() {

		ldriver.findElement(btn_save).click(); 
	}
}
