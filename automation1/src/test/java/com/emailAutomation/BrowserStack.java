package com.emailAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserStack {
	WebDriver driver;
	
	@BeforeMethod
	public void beforemethod()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\avasharm\\myorders-selenium-tests\\myOrders\\Resources\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		    //String url = "http://flipkart.com/";
			
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
