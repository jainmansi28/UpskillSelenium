package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC3_Product {
private WebDriver driver; 
	
	public TC3_Product(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products")
	private WebElement product;
	
	@FindBy(name="filter_name")
    private WebElement prodtextbox;
	
	 @FindBy(id="button-filter")
	    private WebElement filter;
	
	public void clickproduct()  {
		System.out.println("Printing last");
	    //ac.moveToElement(this.category).build().perform();
		this.product.click(); 
		}
	
	public void enterProductName(String prod)  {
		System.out.println("Entering Product Name");
	    this.prodtextbox.sendKeys(prod); 
		}
	
	public void filterbutton() throws InterruptedException  {
		System.out.println("Clicking Filter button");
	    this.filter.click();
	    Thread.sleep(3000);
		}
	
	
}
