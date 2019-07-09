package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TC6_ProductOperations {
private WebDriver driver; 
	
	public TC6_ProductOperations(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//*[@id='catalog']/a")
	 private WebElement catalogmenu;
	 
	 @FindBy(xpath="//*[@id='catalog']/ul/li[2]/a")
	   private WebElement productmenu;
	 	 
	 @FindBy(id="input-price")
	   private WebElement price;
		
	 @FindBy(id="input-status")
	   private WebElement status;
	 
	 @FindBy(id="input-model")
	 private WebElement model;
	 
	 @FindBy(id="input-quantity")
	 private WebElement quantity;
	
	 @FindBy(xpath="//*[@id='form-product']/div/table/tbody/tr[1]/td[3]")
	 private WebElement output;
	
	 public void catalogmenu()  {
		System.out.println("Product Menu");
	    this.catalogmenu.click(); 
		}
	
	public void productmenu()  {
		System.out.println("Product Menu");
	    this.productmenu.click(); 
		}
	
	public void enterPrice(String pricename)  {
		  this.price.sendKeys(pricename); 
		}
 	public void selectStatus (String statusvalue)
 	{
 		Select sc=new Select(this.status);
 		sc.selectByVisibleText(statusvalue);
 		 	}
	public void enterModel(String modelname)  {
		  this.model.sendKeys(modelname); 
		}
	public void enterQuantity(String quantityno)  {
		  this.quantity.sendKeys(quantityno); 
		}
	
	public String getoutput()  {
		 return this.output.getText();
		}
}

	 	




	 	 