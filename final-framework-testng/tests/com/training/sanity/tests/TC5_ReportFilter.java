package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC1_AdminLogin;
//import com.training.pom.TC1_Dashboard;
//import com.training.pom.TC2_Categories;
import com.training.pom.TC5_SalesReport;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC5_ReportFilter {
	
	private WebDriver driver;
	private String baseUrl;
	private TC1_AdminLogin TC1_AdminLogin;
	private TC5_SalesReport TC5_SalesReport;
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
			TC5_SalesReport =new TC5_SalesReport(driver);
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
		screenShot.captureScreenShot("TC5_1");
		Thread.sleep(2000);
		TC5_SalesReport.mainmenu();
		Thread.sleep(2000);
		TC5_SalesReport.Report();		
		Thread.sleep(2000);
		TC5_SalesReport.SalesButton();
		Thread.sleep(2000);
		TC5_SalesReport.Order();
		screenShot.captureScreenShot("TC5_2");
		Thread.sleep(1000);
		TC5_SalesReport.clickcalender1();
		TC5_SalesReport.clickday1("5");
		screenShot.captureScreenShot("TC5_3");
		TC5_SalesReport.clickcalender2();
		TC5_SalesReport.clickday1("24");
		screenShot.captureScreenShot("TC5_4");
		TC5_SalesReport.filter();
		TC5_SalesReport.selectgroup("Weeks");
		TC5_SalesReport.orderstatus("Processing");
		TC5_SalesReport.filter();
		screenShot.captureScreenShot("TC5_5");
		Thread.sleep(1000);
	}	
		
	}

	
	
		
	

