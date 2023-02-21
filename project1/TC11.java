package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC11 {
  @Test
  public void OpenNewAccount() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  
	  driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	  
	  Thread.sleep(3000);
	  String Title = driver.getTitle();
	  String ActTitle = "ParaBank | Welcome | Online Banking";
	  if(Title.equals(ActTitle)) {
		  System.out.println("Home Page verified");
	  }
	  else {
		  System.out.println("Page not verified");
	  }
	  
	  WebElement Usrnme = driver.findElement(By.xpath("//input[@name='username']"));
	  Usrnme.sendKeys("abcd");
	  WebElement Passwrd = driver.findElement(By.xpath("//input[@name='password']"));
	  Passwrd.sendKeys("abcd");
	  WebElement LoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
	  LoginBtn.click();
	  
	  Thread.sleep(3000);
	  String title2 = driver.getTitle();
	  String ActTitle2 = "ParaBank | Accounts Overview";
	 if(title2.equals(ActTitle2)) {
	  System.out.println("Login Successfull");
	}
	  else {
		 System.out.println("Login Failed");
	  }
	 
	 WebElement OpenAcc = driver.findElement(By.xpath("//a[contains(text(),'Open New Account')]"));
	  OpenAcc.click();
	  
	  Thread.sleep(3000);
	  
	  Boolean NewAccPage = driver.findElement(By.xpath("//h1[contains(text(),'Open New Account')]")).isDisplayed();
	  System.out.println("Open New Account Page :"+NewAccPage);
	  
	  Select AccType = new Select(driver.findElement(By.id("type")));
	  AccType.selectByVisibleText("SAVINGS");
	  
	  Select FromAcc = new Select(driver.findElement(By.id("fromAccountId")));
	  FromAcc.selectByVisibleText("13677");
	  
	  WebElement OpenAccBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	  OpenAccBtn.click();
	  
	  Thread.sleep(3000);
	  
	  Boolean AccCrdPage = driver.findElement(By.xpath("//h1[@class='title']")).isDisplayed();
	  System.out.println("Account Opened :"+AccCrdPage);
	  
	  
  }
}
