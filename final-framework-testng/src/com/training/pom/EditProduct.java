package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditProduct {
private WebDriver driver; 
	
	public EditProduct(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
/*	@FindBy(xpath="//*[contains(text(),'GIRLS BLAZER')]")
	private WebElement editprod;*/
	
	 @FindBy(xpath="//*[contains(text(),'GIRLS BLAZER')]//following-sibling::td[5]/a")
	 private WebElement editbutton;
	 	 
	 @FindBy(id="input-quantity")
	 private WebElement quanityno;
	 
		//Functions
		
	public void editprodbutton()  {
			    this.editbutton.click(); 
			   		}
	
		public void clearquanity()  {
			this.quanityno.clear();
		 		}
		
}

	 	




	 	 