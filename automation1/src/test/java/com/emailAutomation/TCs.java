package com.emailAutomation;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TCs {
 
	ChromeDriver obrowser;
	
	
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avasharm\\Downloads\\chromedriver.exe");
		obrowser = new ChromeDriver();

		obrowser.manage().window().maximize();
		obrowser.manage().deleteAllCookies();
		obrowser.get("https://rde2.myorders.medtronic.com/view/content/transactionActivityForm");
		
	
	
	}
	


  @AfterMethod
  public void teardown(ITestResult result) throws EmailException, InterruptedException, HeadlessException, AWTException, IOException
  {
  	if(result.getStatus()==ITestResult.FAILURE)
  		
  	{

  		
  		TakesScreenshot scrShot =((TakesScreenshot)obrowser);
  		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
  		try {
  			
  			//String directory = "C:/Users/mycampusdeployer/Desktop/Screenshots/nmsu4/";
  			
  			String directory = "C:/Users/avasharm/Desktop";
  			String fileName= System.currentTimeMillis()+".png";
  				
  					
  			 // now copy the  screenshot to desired location using copyFile //method
  			FileUtils.copyFile(SrcFile, new File(directory+"\\"+fileName));
  			}
  			 
  			catch (IOException e)
  			 {
  			  System.out.println(e.getMessage());
  			 
  			 }

			String ss3= result.getName();
			String ss4 = obrowser.getCurrentUrl();
			email.sendemail4(ss3, SrcFile, ss4);
		
}
  	
  }
}
