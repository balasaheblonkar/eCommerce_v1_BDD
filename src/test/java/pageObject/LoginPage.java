package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage (WebDriver rdriver)
	{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this) ;
	}
	
	
	@FindBy(name="Email")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy (name="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (xpath="//button[text()='Log in']")
	@CacheLookup
	WebElement btnLogin;
	

	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement lnkLogout;

	public void setUserName (String uname) 
	{
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}

}
