package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TC7_AddProduct {
private WebDriver driver; 
	
	public TC7_AddProduct(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 //@FindBy(xpath="//a[@class='btn btn-primary']")
	 @FindBy(xpath="//*[@id='content']/div[1]/div/div/a")
	private WebElement addprod;
	
	 @FindBy(id="input-name1")
	 private WebElement prodname;
	
	 @FindBy(id="input-meta-title1")
	 private WebElement titlename;

	 @FindBy(xpath="//a[text()='Data']")
	 private WebElement datatab;
	 
	 @FindBy(id="input-model")
	 private WebElement modelname;
	 
	 @FindBy(id="input-price")
	 private WebElement priceno;
	 
	 @FindBy(id="input-quantity")
	 private WebElement quanityno;
	 
	 @FindBy(xpath="//a[text()='Links']")
	 private WebElement linktab;
	 
	 @FindBy(id="input-category")
	 private WebElement category;
	
		 
	 @FindBy(xpath="//a[text()='Uniform']")
	 private WebElement selectcategory;
	 
	 @FindBy(xpath="//button[@type='submit']")
	 private WebElement save;
	 
	  @FindBy(xpath="//div[@class='alert alert-success']")
			private WebElement succtext1; 
	//Functions
		
	public void addprodbutton()  {
			    this.addprod.click(); 
			    System.out.println("Button clicked");
		}
	
		public void enterprodname(String prod)  {
		  this.prodname.sendKeys(prod); 
		}
		
		public void enterprodtitlename(String meta)  {
			  this.titlename.sendKeys(meta); 
			}
		
		public void clickdata()  {
		    this.datatab.click(); 
	}
		public void enterModel1(String modelname)  {
			  this.modelname.sendKeys(modelname); 
			}
		public void enterprice(String price)  {
			  this.priceno.sendKeys(price); 
			}
		public void enterQuantity1(String quantityno)  {
			  this.quanityno.sendKeys(quantityno); 
			}
		public void clicklink()  {
		    this.linktab.click(); 
	}
		
		public void clickcategory()  {
		    this.category.click(); 
	}
		public void addcategory()  {
		    this.selectcategory.click(); 
	}
 	
		public void savebutton()  {
		    this.save.click(); 
	}
		
		public String sucessmessage1() {
			System.out.println("after delete button ");	
			String str=succtext1.getText();
			String[] splited = str.split("\\s+");
			System.out.println("My string is "+splited[0]);
			String Actual=splited[0];
			return Actual;
		}
}

	 	




	 	 