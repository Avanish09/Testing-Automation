package com.emailAutomation;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserStack{
		
	WebDriver driver;
	public static final String USERNAME = "avanishsharma_gRSLlx";
	public static final String AUTOMATE_KEY = "j9EfZmhkfF1QQJv5Wp27";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	

	@Parameters({"os", "osVersion", "browserName", "browserVersion"})
	@BeforeMethod
	public void beforemethod1(String browserName, String os, String osVersion, String browserVersion) throws MalformedURLException
	
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\avasharm\\myorders-selenium-tests\\myOrders\\Resources\\Drivers\\chromedriver.exe");
		
		 
		 DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("browserName", browserName);
			capabilities.setCapability("browserVersion", browserVersion);
			capabilities.setCapability("os", os);
			capabilities.setCapability("osVersion", osVersion);
			HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		    //String url = "http://flipkart.com/";
			 driver = new RemoteWebDriver(new java.net.URL (URL), capabilities );
			//driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://flipkart.com/");
			
		
	}
	
  @Test
  public void flipkart() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 WebElement popup = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
 popup.click();
 
 WebElement search = driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]"));
 search.sendKeys("Samsung Galaxy S10");
 
 WebElement searchbtn = driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]"));
 searchbtn.click();
 
 WebElement clickmobile = driver.findElement(By.xpath("//a[@title='Mobiles']"));
 clickmobile.click();
 

 WebElement clicksamsung = driver.findElement(By.xpath("//div[@title='SAMSUNG']//div[@class='_24_Dny']"));
 clicksamsung.click();
 
 Thread.sleep(5000);
 WebElement clickassured = driver.findElement(By.xpath("//div[@class='_24_Dny _3tCU7L']"));
 clickassured.click();
 
 Thread.sleep(5000);
 WebElement clickprice = driver.findElement(By.xpath("//div[normalize-space()='Price -- High to Low']"));
 clickprice.click();
 
 Thread.sleep(10000);
		
 List<WebElement> resultsList = driver.findElements(By.xpath(".//*[starts-with(@class, '_4rR01T')]"));

 
 
 for (WebElement result:resultsList) {
	 
System.out.println(result.getText());               
  
 }
	
	  Thread.sleep(10000); 
	  List<WebElement> resultsList2 = driver.findElements(By.xpath(".//*[starts-with(@class, '_30jeq3 _1_WHN1')]"));
	  
	  for (WebElement result1:resultsList2) {
	  System.out.println(result1.getText()); }
	  
	  

	  Thread.sleep(10000); 
	  List<WebElement> resultsList3 = driver.findElements(By.xpath(".//*[starts-with(@class, '_1fQZEK')]"));
	  for (WebElement result2:resultsList3) {
	  System.out.println(result2.getAttribute("href")); }
	 
 
		
  }
  @AfterMethod
  public void teardown()
  {
	  
	  driver.quit();
	  
  }
}
