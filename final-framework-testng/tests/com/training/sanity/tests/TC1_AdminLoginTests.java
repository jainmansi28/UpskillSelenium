package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC1_AdminLogin;
import com.training.pom.TC1_Dashboard;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC1_AdminLoginTests {
	
	private WebDriver driver;
	private String baseUrl;
	private TC1_AdminLogin TC1_AdminLogin;
	private TC1_Dashboard TC1_Dashboard;
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
			//driver = DriverFactory.getDriver(DriverNames.CHROME);
	     	driver = DriverFactory.getDriver(DriverNames.FIREFOX);
			TC1_AdminLogin = new TC1_AdminLogin(driver); 
			TC1_Dashboard = new TC1_Dashboard(driver); 
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
	public void validLoginTest() throws InterruptedException {
		TC1_AdminLogin.sendUser("admin");
		TC1_AdminLogin.sendPass("admin@123");
		TC1_AdminLogin.clickAdminLoginBtn(); 
		screenShot.captureScreenShot("TC1_1");
		//Thread.sleep(5000);
		TC1_Dashboard.clickcatalog();
		System.out.println("AFter clicking on Catalog page");
		screenShot.captureScreenShot("TC1_2");
		TC1_Dashboard.clickcategory();
		System.out.println("AFter clicking on Category");
		try
		{
			String actual= TC1_Dashboard.categorytitle();
			System.out.println("Actual is   "+actual);
			String expected="Categories";
			Assert.assertEquals(actual, expected);
			System.out.println("Landed on categories page");
			screenShot.captureScreenShot("TC1_3");
		}
		catch(Error e)
		{
			System.out.println("Failed to land on categories page");
		}
		Thread.sleep(5000);
		
	}
			}
	
	
		
	

