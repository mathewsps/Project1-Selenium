package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01 {
  @Test
  public void Registation() {
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
	  
	  
	  WebElement Register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
	  Register.click();
	  
	  String title2 = driver.getTitle();
	  String ActTitle2 = "ParaBank | Register for Free Online Account Access";
	  if(title2.equals(ActTitle2)) {
		  System.out.println("Registration page verified");
	  }
	  else {
		  System.out.println("Page not verified");
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
	  ZipCode.sendKeys("560087");
	  WebElement Phone = driver.findElement(By.id("customer.phoneNumber"));
	  Phone.sendKeys("6756756765");
	  WebElement SSN = driver.findElement(By.id("customer.ssn"));
	  SSN.sendKeys("675675");
	 
	  WebElement Usrname = driver.findElement(By.id("customer.username"));
	  Usrname.sendKeys("Mathews12");
	  WebElement Pswd = driver.findElement(By.id("customer.password"));
	  Pswd.sendKeys("Mathews123");
	  WebElement CPswd = driver.findElement(By.id("repeatedPassword"));
	  CPswd.sendKeys("Mathews123");
	  
	  WebElement RegisterBtn = driver.findElement(By.xpath("//input[@value='Register']"));
	  RegisterBtn.click();
	  
	  String Title3 = driver.getTitle();
	  String ActTitle3 = "ParaBank | Customer Created";
	  if(Title3.equals(ActTitle3)) {
		  System.out.println("Customer Created Successfully");
	  }
	  else {
		  System.out.println("Customer Created Successfully");
	  }
	  
	  
  }
}
