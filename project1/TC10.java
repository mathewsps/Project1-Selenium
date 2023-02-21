package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC10 {
  @Test
  public void LogOut() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  
 
	  driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	  
	  
//HOMEPAGE VERIFICATION
	  String Title = driver.getTitle();
	  String ActTitle = "ParaBank | Welcome | Online Banking";
	  if(Title.equals(ActTitle)) {
		  System.out.println("Home Page verified");
	  }
	  else {
		  System.out.println("Page not verified");
	  }
	  
	  
//LOGIN
	  WebElement Usrnme = driver.findElement(By.xpath("//input[@name='username']"));
	  Usrnme.sendKeys("chembusajan");
	  WebElement Passwrd = driver.findElement(By.xpath("//input[@name='password']"));
	  Passwrd.sendKeys("chembusajan");
	  WebElement LoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
	  LoginBtn.click();
	  
//LOGIN VERIFICATION	  
	  String title2 = driver.getTitle();
	  String ActTitle2 = "ParaBank | Accounts Overview";
	 if(title2.equals(ActTitle2)) {
	  System.out.println("Login Successfull");
	}
	  else {
		 System.out.println("Login Failed");
	  }
	 
	 Thread.sleep(3000);

	 
	 
//LOGOUT	 
	 WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
	  logout.click();
	  
	  
//LOGOUT VERIFICATION  
	  String Title3 = driver.getTitle();
	  String ActTitle3 = "ParaBank | Welcome | Online Banking";
	  if(Title3.equals(ActTitle3)) {
		  System.out.println("User Logged Out Sucessfully");
	  }
	  else {
		  System.out.println("LogOut Failed");
	  }
	 
	  
  }
}
