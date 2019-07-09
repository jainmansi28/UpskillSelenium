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
import com.training.pom.TC4_ProdDel;
import com.training.pom.TC3_Product;
import com.training.pom.TC5_SalesReport;
import com.training.pom.TC6_ProductOperations;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC9_MultiProdDel {
	
	private WebDriver driver;
	private String baseUrl;
	private TC1_AdminLogin TC1_AdminLogin;
	private TC1_Dashboard TC1_Dashboard;
	private TC4_ProdDel TC4_ProdDel;
	private TC3_Product TC3_Product;
	private TC5_SalesReport TC5_SalesReport;
	private TC6_ProductOperations TC6_ProductOperations;
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
			TC3_Product =new TC3_Product(driver);
			TC4_ProdDel =new TC4_ProdDel(driver);
			TC5_SalesReport =new TC5_SalesReport(driver);
			TC6_ProductOperations=new TC6_ProductOperations(driver);
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
		TC5_SalesReport.mainmenu();
		System.out.println("Click on Product Menu");
		TC6_ProductOperations.catalogmenu();
		TC6_ProductOperations.productmenu();
		String output=TC4_ProdDel.enterProductName("Red T shirt");
		String expec="Matched";
		Assert.assertEquals(output,expec);
		System.out.println("Element found :Continue to select another");
		screenShot.captureScreenShot("TC4_3");
		String output1=TC4_ProdDel.enterProductName("sports wear");
		String expec1="Matched";
		Assert.assertEquals(output1,expec1);
		System.out.println("Element found :Continue to select another");
		screenShot.captureScreenShot("TC4_3");
		Thread.sleep(5000);
		TC4_ProdDel.clickdelbutton();
		screenShot.captureScreenShot("TC4_2");
		TC4_ProdDel.alertwindow1();
		Thread.sleep(5000);
		try
		{
		String actual=TC4_ProdDel.sucessmessage1();
		System.out.println("Actual is   "+actual);
		String Expected="Success:";
		Assert.assertEquals(actual,Expected);
		System.out.println("Test passed");
	    screenShot.captureScreenShot("TC4_4");
		}
		catch(Error e)
		{
			System.out.println("Unable to delete an entry");
		}
		
				}	
		
	}

	
	
		
	

