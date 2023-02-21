package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07 {
  @Test
  public void PayBill() throws InterruptedException {
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
	  
	  WebElement BPay = driver.findElement(By.xpath("//a[contains(text(),'Bill Pay')]"));
	  BPay.click();
	  
	  Thread.sleep(3000);
	  
	  
	  String title3 = driver.getTitle();
	  String ActTitle3 = "ParaBank | Bill Pay";
	  if(title3.equals(ActTitle3)) {
		  System.out.println("Bill Payment Page verified");
	  }
	  else {
		  System.out.println("Bill Payment Page NOT verified");
	  }
	  
	  WebElement PayeName = driver.findElement(By.xpath("//input[@name='payee.name']"));
	  PayeName.sendKeys("Benji Sajan");
	  WebElement PayeAdrs = driver.findElement(By.xpath("//input[@name='payee.address.street']"));
	  PayeAdrs.sendKeys("PuthPuryil");
	  WebElement PayeCty = driver.findElement(By.xpath("//input[@name='payee.address.city']"));
	  PayeCty.sendKeys("KTM");
	  WebElement PayeState = driver.findElement(By.xpath("//input[@name='payee.address.state']"));
	  PayeState.sendKeys("Kerala");
	  WebElement PayeZip = driver.findElement(By.xpath("//input[@name='payee.address.zipCode']"));
	  PayeZip.sendKeys("686603");
	  WebElement PayePhn = driver.findElement(By.xpath("//input[@name='payee.phoneNumber']"));
	  PayePhn.sendKeys("4536543564");
	  
	  WebElement PayeAcNo = driver.findElement(By.xpath("//input[@name='payee.accountNumber']"));
	  PayeAcNo.sendKeys("45365");
	  WebElement PayeAcNoCNF = driver.findElement(By.xpath("//input[@name='verifyAccount']"));
	  PayeAcNoCNF.sendKeys("45365");
	  
	  WebElement PayAmt = driver.findElement(By.xpath("//input[@name='amount']"));
	  PayAmt.sendKeys("200");
	  
	  Select ACCNo = new Select(driver.findElement(By.xpath("//select[@name='fromAccountId']")));
	  ACCNo.selectByVisibleText("13788");
	  
	  driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
	  
	  Thread.sleep(3000);
	  
	  Boolean Display = driver.findElement(By.xpath("//h1[contains(text(),'Bill Payment Complete')]")).isDisplayed();
	  System.out.println("Bill Payment Completed page :"+Display);
	 	  
		
  }
}
