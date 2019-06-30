package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TC4_ProdDel {
private WebDriver driver; 
	
	public TC4_ProdDel(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 
	 @FindBy(xpath="//*[@id='form-product']/div/table/tbody/tr[1]/td[3]")
	 private WebElement productlist;
		 
	 @FindBy(xpath="//*[@id='form-product']/div/table/tbody/tr[1]/td[1]/input")
	 private WebElement productlistcheck;
	 
	  @FindBy(xpath="//i[@class='fa fa-trash-o']")
		private WebElement delBtn1; 
	  @FindBy(xpath="//div[@class='alert alert-success']")
		private WebElement succtext1; 
	
	  @FindBy(xpath="//*[@id='form-product']/div/table/tbody/tr/td[3]")
	  private List<WebElement> complist;
	 
	  @FindBy(xpath="//*[@id='form-product']/div/table/tbody/tr/td[1]/input")
	  private List<WebElement> checklist;
	  
	public void selproductdel()  {
		System.out.println("Product Selection");
	    //ac.moveToElement(this.category).build().perform();
		String prod=this.productlist.getText();
		System.out.println("Product selected is"+prod);
		this.productlistcheck.click(); 
		}
	public void clickdelbutton()  {
		System.out.println("Entering clickdelbutton function ");
	    this.delBtn1.click(); 
		}
	
	public void alertwindow1() throws InterruptedException {
		System.out.println("Inside Alert");
		Alert alt=driver.switchTo().alert();
		System.out.println("after"+alt.getText());
		alt.accept();
		  	}
	
	public String sucessmessage1() {
		System.out.println("after delete button ");	
		String str=succtext1.getText();
		String[] splited = str.split("\\s+");
		System.out.println("My string is "+splited[0]);
		String Actual=splited[0];
		return Actual;
	}
	
	public String enterProductName(String prodentered)  {
		System.out.println("Entering Product Name"+prodentered);
		int count=this.complist.size();
		String str = null;
	   for (int i=0;i<count;i++) 
	   {
		   String prod1=complist.get(i).getText();
		   if (prod1.equalsIgnoreCase(prodentered))
		   {    
			   System.out.println("Matched");
			   this.checklist.get(i).click();
			   str="Matched";
			   break;
		   }
		      
		}
	 
	 return str;
	 
	}
	

	
	
}
