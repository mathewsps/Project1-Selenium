package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC05 {
  @Test
  public void ContactInfo() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  
	  driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	  String Title = driver.getTitle();
	  String ActTitle = "ParaBank | Welcome | Online Banking";
	  if(Title.equals(ActTitle)) {
		  System.out.println("Home Page verified");
	  }
	  else {
		  System.out.println("Page not verified");
	  }
	  
	  WebElement Usrnme = driver.findElement(By.xpath("//input[@name='username']"));
	  Usrnme.sendKeys("bobansajan");
	  WebElement Passwrd = driver.findElement(By.xpath("//input[@name='password']"));
	  Passwrd.sendKeys("bobansajan");
	  WebElement LoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
	  LoginBtn.click();
	  
	  String title2 = driver.getTitle();
	  String ActTitle2 = "ParaBank | Accounts Overview";
	  if(title2.equals(ActTitle2)) {
		  System.out.println("Login Successfull");
	  }
	  else {
		  System.out.println("Login Failed");
	  }
	  
	  WebElement ContInf = driver.findElement(By.xpath("//a[contains(text(),'Update Contact Info')]"));
	  ContInf.click();
	  
	  String title3 = driver.getTitle();
	  String ActTitle3 = "ParaBank | Update Profile";
	  if(title3.equals(ActTitle3)) {
		  System.out.println("Contact info. upadte page verified");
	  }
	  else {
		  System.out.println("Contact info. update page NOT verified");
	  }
	  
	  WebElement Firstname = driver.findElement(By.id("customer.firstName"));
	  Firstname.sendKeys("Mathews");
	  WebElement LastName = driver.findElement(By.id("customer.lastName"));
	  LastName.sendKeys("PS");
	  WebElement Address = driver.findElement(By.id("customer.address.street"));
	  Address.sendKeys("Skyline 12 B");
	  WebElement City = driver.findElement(By.id("customer.address.city"));
	  City.sendKeys("Kottayam");
	  WebElement State = driver.findElement(By.id("customer.address.state"));
	  State.sendKeys("Kerala");
	  WebElement ZipCode = driver.findElement(By.id("customer.address.zipCode"));
	  ZipCode.sendKeys("686601");
	  WebElement Phone = driver.findElement(By.id("customer.phoneNumber"));
	  Phone.sendKeys("6756756765");
	  WebElement UpdateInfoBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	  UpdateInfoBtn.click();
	  
		boolean text = driver.findElement(By.xpath("//h1[@class='title']")).isDisplayed();
	    System.out.println("Profile Updated : "+text);
	  
	 
  }
}
