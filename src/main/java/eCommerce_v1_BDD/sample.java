package eCommerce_v1_BDD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class sample {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation Projects\\eCommerce_v1_BDD\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement email=driver.findElement(By.name("Email"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
		
		WebElement password=driver.findElement(By.name("Password"));
		password.clear();
		password.sendKeys("admin");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.xpath("//i[@class='nav-icon far fa-user']/following-sibling::p")).click();
		driver.findElement(By.xpath("//p[text()=' Customers']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		
		/*WebElement drp=driver.findElement(By.xpath("//label[text()='Newsletter']/parent::div/parent::div/following-sibling::div/div/div/div"));
		
		Actions act=new Actions(driver);
		act.moveToElement(drp).click().build().perform();
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Your store name']"))).click().perform();*/
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='k-select'][@title='delete']")).click();
		js.executeScript("arguments[0].value='Guests'", driver.findElement(By.xpath("//select[@id='SelectedCustomerRoleIds']")));
		//Select se=new Select(driver.findElement(By.xpath("//select[@id='SelectedCustomerRoleIds']")));
		//Thread.sleep(2000);
		//se.selectByVisibleText("Guests");
		
	}

}
