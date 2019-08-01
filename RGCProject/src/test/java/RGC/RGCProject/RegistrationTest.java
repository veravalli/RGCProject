package RGC.RGCProject;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class RegistrationTest {
	WebDriver driver;
	
	
  @Test
  public void f() throws Exception {
	  
	  Actions a=new Actions(driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  
	  driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();  
	new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ddlSignUpCountry']"))).selectByVisibleText("USA");
	driver.findElement(By.name("ctl00$ContentPlaceHolder1$uctlBusinessAddControl$txtPhone1")).sendKeys("8723634121");
	driver.findElement(By.name("ctl00$ContentPlaceHolder1$uctlBusinessAddControl$txtFName")).sendKeys("Auto");
	driver.findElement(By.name("ctl00$ContentPlaceHolder1$uctlBusinessAddControl$txtLName")).sendKeys("script");
	driver.findElement(By.name("ctl00$ContentPlaceHolder1$uctlBusinessAddControl$txtEmail")).sendKeys("autoscript@relianceada.com");
	
	driver.findElement(By.name("ctl00$ContentPlaceHolder1$uctlBusinessAddControl$txtZip")).sendKeys("10001");
	
	
	WebDriverWait wait=new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_ContentPlaceHolder1_uctlBusinessAddControl_btnFind"))).click();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.switchTo().frame("frameaddress");
	driver.findElement(By.xpath("//input[@id='FindAddress1_dgrCityState_ctl02_Select']")).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.switchTo().defaultContent();
	//driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_uctlBusinessAddControl_txtAddress1']")).sendKeys("MINDQ");
	
	 js.executeScript("window.scrollBy(0,250)", "");
	driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnProceed']")).click();
	new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ctlPlan_ddlPlan']"))).selectByVisibleText("Simply Reliance Plan");
	driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_chkPromotion']")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtPromotion']\")")));
	driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtPromotion']")).sendKeys("RGCP801");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnValidateCode']")).click();
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	 
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium softwares 2019\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://202.138.127.37/RGCPLUS_REVAMP/in/sign-up");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  Thread.sleep(2000);
	  	  
  }

}
