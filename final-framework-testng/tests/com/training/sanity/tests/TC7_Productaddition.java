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
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ExternReport;
import com.training.pom.TC1_AdminLogin;
import com.training.pom.TC1_Dashboard;
import com.training.pom.TC6_ProductOperations;
import com.training.pom.TC3_Product;
import com.training.pom.TC5_SalesReport;
import com.training.pom.TC7_AddProduct;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC7_Productaddition {
	
	private WebDriver driver;
	private String baseUrl;
	private TC1_AdminLogin TC1_AdminLogin;
	private TC1_Dashboard TC1_Dashboard;
	private TC3_Product TC3_Product;
	private TC6_ProductOperations TC6_ProductOperations;
	private TC5_SalesReport TC5_SalesReport;
	private TC7_AddProduct TC7_AddProduct;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExternReport ExternReport;
	
	
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
			TC3_Product =new TC3_Product(driver);
			TC5_SalesReport=new TC5_SalesReport(driver);
			TC6_ProductOperations =new TC6_ProductOperations(driver);
			TC7_AddProduct=new TC7_AddProduct(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			ExternReport =new ExternReport(driver);
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
		screenShot.captureScreenShot();
		Thread.sleep(2000);
		TC5_SalesReport.mainmenu();
		System.out.println("Click on Product Menu");
	   	TC6_ProductOperations.catalogmenu();
		TC6_ProductOperations.productmenu();
		screenShot.captureScreenShot();
		TC7_AddProduct.addprodbutton();
		TC7_AddProduct.enterprodname("XYZ");
		TC7_AddProduct.enterprodtitlename("Shirt for girls");
		Thread.sleep(5000);
		TC7_AddProduct.clickdata();
		TC7_AddProduct.enterModel1("SHG-010");
		TC7_AddProduct.enterprice("5000");
		TC7_AddProduct.enterQuantity1("150");
		TC7_AddProduct.clicklink();
		TC7_AddProduct.clickcategory();
		TC7_AddProduct.addcategory();
		TC7_AddProduct.savebutton();
		try
		{
		String actual=TC7_AddProduct.sucessmessage1();
		System.out.println("Actual is   "+actual);
		String Expected="Success:";
		Assert.assertEquals(actual,Expected);
		System.out.println("Test passed");
	    screenShot.captureScreenShot();
		}
		catch(Error e)
		{
			System.out.println("Unable to update the record");
		}
		
				}	
	}


	
	
		
	

