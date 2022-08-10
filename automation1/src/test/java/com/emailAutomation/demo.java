package com.emailAutomation;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ParallelTest implements Runnable {
	public static final String USERNAME = "avanishsharma_gRSLlx";
	public static final String AUTOMATE_KEY = "j9EfZmhkfF1QQJv5Wp27";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	Hashtable<String, String> capsHashtable;
	String sessionName;

	ParallelTest(Hashtable<String, String> cap, String sessionString) {
		capsHashtable = cap;
		sessionName = sessionString;
	}

	public void run() {
    DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("bstack:options", capsHashtable);
		caps.setCapability("sessionName", sessionName); // test name
		caps.setCapability("buildName", "BStack-[Java] Sample build"); 
		caps.setCapability("browserstack.console", "info");
		HashMap<String, Boolean> networkLogsOptions = new HashMap<String, Boolean>();
		networkLogsOptions.put("captureContent", true);
		caps.setCapability("browserstack.networkLogs", true);
		caps.setCapability("browserstack.networkLogsOptions", networkLogsOptions);
		caps.setCapability("browserstack.debug", "true");// CI/CD job or build name
		WebDriver driver;
		
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://flipkart.com/");
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
			
			  for (WebElement result:resultsList)
			  {
				  System.out.println(result.getText()); }
			 
				
				  Thread.sleep(10000); 
				  List<WebElement> resultsList2 = driver.findElements(By.xpath(".//*[starts-with(@class, '_30jeq3 _1_WHN1')]"));
				  
					/*
					 * for (WebElement result1:resultsList2) {
					 * System.out.println(result1.getText()); }
					 */
				  for (WebElement result1:resultsList2) {
					  System.out.println(result1.getAttribute("textContent")); 
					  }
				  

				  Thread.sleep(10000); 
				  List<WebElement> resultsList3 = driver.findElements(By.xpath(".//*[starts-with(@class, '_1fQZEK')]"));
				  for (WebElement result2:resultsList3) {
				  System.out.println(result2.getAttribute("href")); }
			
			driver.quit();
			} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
  }
}

public class demo {
	public static void main(String[] args) throws Exception {
		List<Hashtable<String, String>> caps = new ArrayList<Hashtable<String, String>>();		
		
		  //device 1 
		Hashtable<String, String> cap1 = new Hashtable<String, String>();
		  cap1.put("os", "windows"); 
		  cap1.put("osVersion", "10"); 
		  cap1.put("browserVersion", "103");
		  cap1.put("browserName", "Chrome");
			
		  //device 2 
		  Hashtable<String, String> cap2 = new Hashtable<String, String>();
			  cap2.put("os", "windows"); cap1.put("osVersion", "10");
			  cap2.put("browserVersion", "102"); 
			  cap2.put("browserName", "Chrome");
			  caps.add(cap2);
			  
			  
	
			 
		
		
    

    for (Hashtable<String, String> cap : caps) {
      Thread thread = new Thread(new ParallelTest(cap, "Parallel test"));
      thread.start();
    }
	
	}
	
	}
