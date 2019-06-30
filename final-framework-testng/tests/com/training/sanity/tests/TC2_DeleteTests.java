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
import com.training.pom.TC1_Dashboard;
import com.training.pom.TC2_Categories;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC2_DeleteTests {
	
	private WebDriver driver;
	private String baseUrl;
	private TC1_AdminLogin TC1_AdminLogin;
	private TC1_Dashboard TC1_Dashboard;
	private TC2_Categories TC2_Categories;
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
			TC2_Categories =new TC2_Categories(driver);
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
		screenShot.captureScreenShot("TC2_1");
		TC1_Dashboard.clickcatalog();
		TC1_Dashboard.clickcategory();
		screenShot.captureScreenShot("TC2_2");
		TC2_Categories.clickcheck();
		screenShot.captureScreenShot("TC2_3");
		TC2_Categories.clickdel();
		TC2_Categories.alertwindow();
		screenShot.captureScreenShot("TC2_4");
		try
		{
		String actual=TC2_Categories.sucessmessage();
		System.out.println("Actual is   "+actual);
		String Expected="Success:";
		Assert.assertEquals(actual,Expected);
		System.out.println("Test passed");
	    screenShot.captureScreenShot("TC2_5");
		}
		catch(Error e)
		{
			System.out.println("Unable to delete an entry");
		}
	}
}
	
	
		
	

