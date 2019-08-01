package RGC.RGCProject;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class RGCLoginTest {
	WebDriver driver;
	
	Logger logger=Logger.getLogger(RGCLoginTest.class);
	
	
  @Test(priority = 0)
  public void RGC_Login() {
	  
	 driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_UserName']")).sendKeys("145645645454");
	 driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_Password']")).sendKeys("6959");
	 driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_LoginImageButton']")).click();
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
	 logger.info("Login Success");
  }
  
  @Test(priority = 1)
  public void RGC_Recharge() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);   
	  driver.findElement(By.xpath("//li[@class='nav-header rechargeSuccess']//a[contains(text(),'Recharge')]")).click();
	  new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ddlProdSubType']"))).selectByVisibleText("Simply Reliance Plan");
	  new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ctlPayment_ddlPaymentMode']"))).selectByVisibleText("Credit Card");
	  new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ctlPayment_ddlCardType']"))).selectByVisibleText("Visa");
	 // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_ctlPayment_txtCardNumber']")).sendKeys("4000000000000002");
	  driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_ctlPayment_txtCVV']")).sendKeys("123");
	  new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ctlPayment_ddlExpMonth']"))).selectByVisibleText("Feb");
	  new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ctlPayment_ddlExpYear']"))).selectByVisibleText("2021");
	  new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ddlPayment']"))).selectByVisibleText("20");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
	  logger.info("Recharge Confirmation page");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnConfirm']")).click();
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  	  
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium softwares 2019\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://202.138.127.37/RGCPLUS_REVAMP/login");
	  driver.manage().window().maximize();
	  logger.info("RGC Site opened");
  }

}
