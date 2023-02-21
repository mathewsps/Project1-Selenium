package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC08 {
  @Test
  public void FindTransactions() throws InterruptedException {
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
	  Usrnme.sendKeys("bobansajan");
	  WebElement Passwrd = driver.findElement(By.xpath("//input[@name='password']"));
	  Passwrd.sendKeys("bobansajan");
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
	  
//FIND TRANSACTION LINK	  
	  WebElement FindTr = driver.findElement(By.xpath("//a[contains(text(),'Find Transactions')]"));
	  FindTr.click();
	  
	  Thread.sleep(3000);
	  
//FIND TRANSACTION PAGE VERIFICATION	  
	  Boolean FindTrPage = driver.findElement(By.xpath("//h1[contains(text(),'Find Transactions')]")).isDisplayed();
	  System.out.println("Find Transaction Page Verified :"+FindTrPage);
	  
	  
//SELECTING ACCOUNT NUMBER	  
	  Select Accountno = new Select(driver.findElement(By.id("accountId")));
	  Accountno.selectByVisibleText("13788");
	  
//FIND BY TRANSACTION ID  
	   WebElement id = driver.findElement(By.id("criteria.transactionId"));
	  id.sendKeys("14920");
	  WebElement findTraBtn1 = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
	  findTraBtn1.click();
	  
	  
//FIND BY TRANSACTION DATE
	  WebElement date = driver.findElement(By.xpath("//input[@id='criteria.onDate']"));
	  date.sendKeys("02-21-2023");
	  WebElement findTraBtn2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
	  findTraBtn2.click();
	  
	  
//FIND BY TRANSACTION DATE RANGE
	  WebElement DateRange1 = driver.findElement(By.id("criteria.fromDate"));
      DateRange1.sendKeys("02-15-2023");
      WebElement DateRange2 = driver.findElement(By.id("criteria.toDate"));
      DateRange2.sendKeys("02-21-2023");
	  WebElement findTraBtn3 = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
	  findTraBtn3.click(); 
	  
	  
//FIND TRANSACTION BY AMOUNT
	   WebElement Amount = driver.findElement(By.id("criteria.amount"));
	   Amount.sendKeys("200");
	   WebElement findTraBtn4 = driver.findElement(By.xpath("(//button[@type='submit'])[4]"));
	   findTraBtn4.click();
		
	  
	  
//TRANSACTION RESULTS VERIFICATION
	  Thread.sleep(5000);
	  
	  Boolean TrnFound = driver.findElement(By.xpath("//h1[contains(text(),'Transaction Results')]")).isDisplayed();
	  System.out.println("Transaction Results :"+TrnFound);
	  
	 	
  }
}
