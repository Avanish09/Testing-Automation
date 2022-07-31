package com.emailAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class RDE {
	
	 WebDriver driver; 
	
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {		
	
		//System.setProperty("driver destination url");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		
		 WebDriver driver = new ChromeDriver();	
		driver.get("url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
				
	}
 
	@Test
	public void test() throws AWTException
	
	{
		
		
		
		
		
		  
		  WebElement scroller1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/button[1]"));
		  
		  scroller1.click();
		  
		  WebElement scrollimage1 = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/img[1]"));
		
		  
		  scrollimage1.click();
		  
		  WebElement scrollcontent1 = driver.findElement(By.xpath("//img[@class='sc-hWBuOZ hZGRoA']")); 
		  
		  if(scrollcontent1.isDisplayed())
			  
		  {
			  
			  
			  System.out.print("Play button of the video is loaded successfully");
		  }
		  
		
		  
		  
		  
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {		
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avasharm\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		driver = new ChromeDriver(options);		
		driver.get("https://rde2.myorders.medtronic.com/view/content/transactionActivityForm");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
				
	}
	
	
	@Test
	public void login_page_failed() throws EmailException, InterruptedException, HeadlessException, AWTException, IOException{
		
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement login_btn = driver.findElement(By.xpath("//button[@type='submit']"));
		WebElement password = driver.findElement(By.id("password"));
		String titles = "Medtronic";
		String actualtitle  = driver.getTitle();
		System.out.println("Title of the page is:" + actualtitle);
		
		
		
		if(username.isDisplayed() && password.isDisplayed() && login_btn.isDisplayed() )
			
		{
			assertEquals(actualtitle, titles);
			
			System.out.println("Login page is loaded successfully");
		}
		
		else
		{
			System.out.println("Login page has not loaded successfully");
			
		}
		
		
	}
	
	@Test
	public void PostLogin_page_Failed() throws EmailException, InterruptedException, HeadlessException, AWTException, IOException{		
		
		
		WebElement username = driver.findElement(By.id("username"));
		 
		 username.sendKeys("chauhn2");
		 
		 WebElement password = driver.findElement(By.id("password"));
		 
		  password.sendKeys("Random@2021");
		  
		 WebElement login_btn =
		  driver.findElement(By.xpath("//button[@type='submit']"));
		  login_btn.click();
		  
		String titles = "Medtronic";
		String actualtitle  = driver.getTitle();
		System.out.println("Title of the page is:" + actualtitle);
		WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
		
		WebElement hamburger = driver.findElement(By.xpath("//header/a[1]"));
		
		
		if(search.isDisplayed() && hamburger.isDisplayed())
			
		{
			assertEquals(actualtitle, titles);
			
			System.out.println("Landing page has loaded successfully");
		}
		
		else
		{
			System.out.println("Landing page has not loaded successfully");
			
		}
		
	}
	
	@Test
	public void Logout_Failed() throws EmailException, InterruptedException, HeadlessException, AWTException, IOException{		
		
		
		WebElement username = driver.findElement(By.id("username"));
		 
		 username.sendKeys("chauhn2");
		 
		 WebElement password = driver.findElement(By.id("password"));
		 
		  password.sendKeys("Random@2021");
		  
		 WebElement login_btn =
		  driver.findElement(By.xpath("//button[@type='submit']"));
		  login_btn.click();
		  
		  WebElement logout_btn3 =driver.findElement(By.xpath("//header/div[2]/p[1]/span[3]"));
		  logout_btn3.click();
		  WebElement logout_btn1 =driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
		  logout_btn1.click();
		  Thread.sleep(2000);
		  
		  //WebElement logout_btn2 = driver.findElement(By.xpath("//*[@id='log-in-form']/fieldset/div/input[2]"))
		  driver.findElement(By.xpath("//*[@id='log-in-form']/fieldset/div/input[2]")).click();
		  
		  Thread.sleep(2000);
		 
		String titles = "Medtronic";
		String actualtitle  = driver.getTitle();
		System.out.println("Title of the page is:" + actualtitle);
		
		
		
		if(username.isDisplayed() && password.isDisplayed() && login_btn.isDisplayed() )
			
		{
			assertEquals(actualtitle, titles);
			
			System.out.println("Logout is successful");
		}
		
		else
		{
			System.out.println("Logout is successful");
			
		}
		
	}

  @AfterMethod
  public void teardown(ITestResult result) throws EmailException, InterruptedException, HeadlessException, AWTException, IOException{
	  
	  if(result.getStatus()==ITestResult.FAILURE)
  		
  	{

  		
  		TakesScreenshot scrShot =((TakesScreenshot)driver);
  		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
  		try {
  			
  			//String directory = "C:/Users/mycampusdeployer/Desktop/Screenshots/nmsu4/";
  			
  			String directory = "C:/Users/avasharm/Desktop/Monitor";
  			String fileName= System.currentTimeMillis()+".png";
  				
  					
  			 // now copy the  screenshot to desired location using copyFile //method
  			FileUtils.copyFile(SrcFile, new File(directory+"\\"+fileName));
  			}
  			 
  			catch (IOException e)
  			 {
  			  System.out.println(e.getMessage());
  			 
  			 }

			String ss3= result.getName();
			String ss4 = driver.getCurrentUrl();
			email.sendemail4(ss3, SrcFile, ss4);
		
}*/
  	//driver.quit();
  	
 