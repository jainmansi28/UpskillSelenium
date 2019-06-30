package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC1_Dashboard {
private WebDriver driver; 
	
	public TC1_Dashboard(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
    //@FindBy(xpath="//*[@id=\"catalog\"]/a/i")
	//@FindBy(css="i.fa.fa-tags.fa-fw")
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catalog; 
	
	//@FindBy(linkText="Categories")
	@FindBy(xpath="//li[@id='catalog']//ul//li//a")
	private WebElement category;
	

	
	public void clickcatalog() throws InterruptedException {
		System.out.println("Printing before");
	    Actions ac=new Actions(driver);
		ac.moveToElement(this.catalog).build().perform(); 
		System.out.println("Printing  after");
			
	}
	
	public void clickcategory()  {
		System.out.println("Printing last");
	    //ac.moveToElement(this.category).build().perform();
		this.category.click(); 
			}
	
	public String categorytitle()  {
		return this.driver.getTitle();
	
	}
	
}
