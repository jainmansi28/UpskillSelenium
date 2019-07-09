package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ExternReport;
import com.training.pom.TC1_AdminLogin;
import com.training.pom.TC1_Dashboard;
import com.training.pom.TC6_ProductOperations;
import com.training.pom.TC3_Product;
import com.training.pom.TC5_SalesReport;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC6_Productsearch {
	
	private WebDriver driver;
	private String baseUrl;
	private TC1_AdminLogin TC1_AdminLogin;
	private TC1_Dashboard TC1_Dashboard;
	private TC3_Product TC3_Product;
	private TC6_ProductOperations TC6_ProductOperations;
	private TC5_SalesReport TC5_SalesReport;
	private static Properties properties;
	private ScreenShot screenShot;
	//Extent Report Implementation
	private static ExtentReports report;
	private ExtentTest logger;
		
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		//Extent Report Implementation
		report=new ExtentReports("C:\\Mansi_Backup\\IBM UPSKILL-SELENIUM-29May2019\\Reports\\TC6.html");
	}
	

	@BeforeMethod
	public void setUp() throws Exception {
	     	System.out.println("Executing Before Method");
			//driver = DriverFactory.getDriver(DriverNames.CHROME);
			driver = DriverFactory.getDriver(DriverNames.FIREFOX);
			TC1_AdminLogin = new TC1_AdminLogin(driver); 
			TC1_Dashboard = new TC1_Dashboard(driver); 
			TC3_Product =new TC3_Product(driver);
			TC5_SalesReport=new TC5_SalesReport(driver);
			TC6_ProductOperations =new TC6_ProductOperations(driver);
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
		logger=report.startTest("Login Test");
		logger.log(LogStatus.INFO, "We are going to enter username and password");
		TC1_AdminLogin.sendUser("admin");
		logger.log(LogStatus.PASS,"username entered");
		TC1_AdminLogin.sendPass("admin@123");
		logger.log(LogStatus.PASS,"Password entered");
		TC1_AdminLogin.clickAdminLoginBtn(); 
		logger.log(LogStatus.INFO,"userrname and password enetered");
		logger.log(LogStatus.PASS,"Login Button clicked");
		screenShot.captureScreenShot("TC6_1");
		Thread.sleep(2000);
		report.endTest(logger);
		report.flush();
		logger=report.startTest("Main Menu Test");
		logger.log(LogStatus.INFO, "going to click on Product Menu button");
		TC5_SalesReport.mainmenu();
		logger.log(LogStatus.PASS,"Main menu clicked");
		TC6_ProductOperations.catalogmenu();
		logger.log(LogStatus.PASS,"Catalog Menu clicked");
		TC6_ProductOperations.productmenu();
		logger.log(LogStatus.PASS,"Product Menu clicked");
		logger.log(LogStatus.INFO,"Landed on Product Menu page");
		report.endTest(logger);
		report.flush();
		logger=report.startTest("Product Search filter");
		logger.log(LogStatus.INFO, "Enter Product");
		screenShot.captureScreenShot("TC6_2");
		TC3_Product.enterProductName("GIRLS BLAZER(9TH-12TH STD)");
		logger.log(LogStatus.PASS,"Product name Entered");
		TC3_Product.filterbutton();
	    screenShot.captureScreenShot("TC6_3");
	    logger.log(LogStatus.PASS,"Price Entered");
	    TC6_ProductOperations.enterPrice("3000");
	    logger.log(LogStatus.PASS,"Price Entered");
		TC3_Product.filterbutton();
		screenShot.captureScreenShot("TC6_4");
		TC6_ProductOperations.selectStatus("Enabled");
	    logger.log(LogStatus.PASS,"Enter Status");
		TC3_Product.filterbutton();
		screenShot.captureScreenShot("TC6_5");
		TC6_ProductOperations.enterModel("BLG-112");
		logger.log(LogStatus.PASS,"Enter Model");
		TC3_Product.filterbutton();
		screenShot.captureScreenShot("TC6_6");
		TC6_ProductOperations.enterQuantity("5000");
		logger.log(LogStatus.PASS,"Enter Quanity");
		TC3_Product.filterbutton();
		screenShot.captureScreenShot("TC6_7");
		try
		{
			String actual=TC6_ProductOperations.getoutput();
			String expected="GIRLS BLAZER(9TH-12TH STD)";
			Assert.assertEquals(actual, expected);
			System.out.println("Test Case passed");
			report.endTest(logger);
			report.flush();
					
		}
		catch(Exception e)
		{
			System.out.println(" No Matching row selected");
		}
		
	}
	}

	
	
		
	

