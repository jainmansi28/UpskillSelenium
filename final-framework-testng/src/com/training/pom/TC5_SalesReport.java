package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TC5_SalesReport {
private WebDriver driver; 
	
	public TC5_SalesReport(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//a[@id='button-menu']")
	   private WebElement menu;
	 
	 @FindBy(xpath="//*[@id='reports']")
	   private WebElement report;
	 
	  @FindBy(xpath="//*[@id= 'reports']/ul/li[1]/a")
	    private WebElement sales;
	  
	  @FindBy(xpath="//*[@id='reports']/ul/li[1]/ul/li[1]/a")
	   private WebElement order;
	  
	  @FindBy(xpath="//*[@name='filter_date_start']//parent::div//span//button")
	   private WebElement calbutton1;
	  
	  @FindBy(xpath="//*[@class='day']")
	  private List<WebElement> day1; 
	  
	  @FindBy(xpath="//*[@name='filter_date_end']//parent::div//span//button")
	   private WebElement calbutton2;
	  
	  @FindBy(id="button-filter")
	  private WebElement filterbutton;
	  
	  @FindBy(id="input-group")
	  private WebElement group;
	  
	  @FindBy(id="input-status")
	  private WebElement status;
	  
	  
		
	public void mainmenu()  {
		System.out.println("Main Menu");
	    //ac.moveToElement(this.category).build().perform();
		this.menu.click(); 
		}
	
	public void Report()  {
		System.out.println("Click on Report");
	    this.report.click(); 
		}
	
	public void SalesButton()  {
		System.out.println("Click on Sales Report");
	    this.sales.click(); 
		}
	
	public void Order()  {
		System.out.println("Click on Orders");
	    this.order.click(); 
		}
	
		 public void clickcalender1() throws InterruptedException {
		 this.calbutton1.click();
		 Thread.sleep(2000);
				 } 
	 
	 public void clickday1(String day) throws InterruptedException {
		int count=day1.size();
		System.out.println("Print size is " +count);
		int i;
		for (i=1;i<=count;i++)
		{
		String text= day1.get(i).getText();
		System.out.print("Print day" +i );
		System.out.println("text is" +text );
				if(text.equalsIgnoreCase(day))
				{
					day1.get(i).click();;
					break;
				}
				 
	 }
		Thread.sleep(2000);
}
	 	 public void clickcalender2() throws InterruptedException {
	 	    this.calbutton2.click();
		     Thread.sleep(2000);
 
	 	 } 
	 	public void filter()  {
			System.out.println("Click on Filterbutton");
		    this.filterbutton.click();
			}
	 	
	 	
	 	public void selectgroup (String groupvalue)
	 	{
	 		Select sc=new Select(this.group);
	 		sc.selectByVisibleText(groupvalue);
	 		
	 	}
	 	public void orderstatus (String statusvalue)
	 	{
	 		Select sc=new Select(this.status);
	 		sc.selectByVisibleText(statusvalue);
	 			 	}
}
	 	




	 	 