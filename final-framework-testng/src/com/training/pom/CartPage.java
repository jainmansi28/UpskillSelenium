package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
private WebDriver driver; 
	
	public CartPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 //@FindBy(xpath="//a[@class='btn btn-primary']")
	 @FindBy(xpath="//*[@class='fa fa-shopping-cart fa-fw']")
	 private WebElement cart;
	 
	 @FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
	 private WebElement cartorder;
	 
	 @FindBy(xpath="//a[text()='2']")
	 private WebElement page2;
	 
	 @FindBy(xpath="//td[text()='Krishna Mohan']")
	  private WebElement name;
	 
	 @FindBy(xpath="//td[text()='Krishna Mohan']//following-sibling::td[5]/a")
	 private WebElement view;
	 
	 @FindBy(xpath="//a[@data-original-title='Print Invoice']")
	 private WebElement print;
	
	 @FindBy(xpath="//h1[contains(text(),'Invoice')]")
	 private WebElement getinvoice;
	 
	 @FindBy(xpath="//td/a[text()='Uniform Store']")
	 private WebElement uniform;
	 
	//Functions
		
	public void clickcart()  {
		  Actions ac=new Actions(driver);
			ac.moveToElement(this.cart).click().build().perform(); 
				    		}
	
	public void clickorder()  {
			    this.cartorder.click(); 
			    		}
	public void clickpage2()  {
	    this.page2.click(); 
	    		}
	public void clickview()  {
	    this.view.click(); 
	    		}
	
	public void clickprint()  {
	    this.print.click(); 
	    		}
	
	public void switchwindow()  {
	  Set<String> window= driver.getWindowHandles();
	  Iterator<String> itr = window.iterator();
	  String main=itr.next();
	  String childtab=itr.next();
	  driver.switchTo().window(childtab);
	  
	    		}
	
	public void switchback()  {
		 Set<String> window= driver.getWindowHandles();
		  Iterator<String> itr = window.iterator();
		  String main=itr.next();
		  String childtab=itr.next();
		  driver.switchTo().window(main);
		//this.driver.switchTo().defaultContent(); // This is not working 
	;	    		}
	
	public String printinvoice()  {
	 
	return this.getinvoice.getText();
	 	    		}
	
	public void uniform()
	{
		this.uniform.click();
		 	    		}
		
	
}

	 	




	 	 