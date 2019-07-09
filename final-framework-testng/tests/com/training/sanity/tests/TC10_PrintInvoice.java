package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC1_AdminLogin;
import com.training.pom.CartPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC10_PrintInvoice {
	
	private WebDriver driver;
	private String baseUrl;
	private TC1_AdminLogin TC1_AdminLogin;
	private CartPage CartPage;
	private static Properties properties;
	private ScreenShot screenShot;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	

	@BeforeMethod
	public void setUp() throws Exception {
	     	System.out.println("Executing Before Method");
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			//driver = DriverFactory.getDriver(DriverNames.FIREFOX);
			TC1_AdminLogin = new TC1_AdminLogin(driver); 
			CartPage = new CartPage(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void deletecategory() throws InterruptedException {
		TC1_AdminLogin.sendUser("admin");
		TC1_AdminLogin.sendPass("admin@123");
		TC1_AdminLogin.clickAdminLoginBtn(); 
		screenShot.captureScreenShot("TC4_1");
	    Thread.sleep(2000);
		CartPage.clickcart();
		CartPage.clickorder();
		CartPage.clickpage2();
		CartPage.clickview();
		CartPage.clickprint();
		CartPage.switchwindow();
		try
		{
		String actual=CartPage.printinvoice();
		System.out.println("Print the value "+actual);
		String Expected="Invoice";
		boolean assertcheck=actual.contains(Expected);
		Assert.assertTrue(assertcheck);
		System.out.println("Test passed");
	    screenShot.captureScreenShot();
		}
		catch(Error e)
		{
			System.out.println("Test Failed to get the invoice number");
		}
		Thread.sleep(2000);
		CartPage.switchback();// going back to the parent window  
		Thread.sleep(5000);
		CartPage.uniform();
		Thread.sleep(5000);
	}
}
	
	
		
	

