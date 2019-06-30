package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class TC2_Categories {
private WebDriver driver; 
	
	public TC2_Categories(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
   @FindBy(xpath="//*[@id=\"catalog\"]/a/i")
	private WebElement catalog; 
	
	@FindBy(linkText="Categories")
	private WebElement category;
	
	//@FindBy(xpath="//input[@value='347']")
	@FindBy(xpath="//table//tbody//tr[1]//td[1]//input")
	private WebElement checkbox; 
	
	//@FindBy(css="button.btn.btn-danger")
    //@FindBy(xpath="//*[@id='content']/div[1]/div/div/button")
	//@FindBy(xpath="//button[@type='button']")
	
	//@FindBy(xpath="//button[@class='btn btn-danger']")
    @FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement delBtn; 

	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement succtext; 
		
	public void clickcheck() throws InterruptedException {
			this.checkbox.click(); 
			Thread.sleep(3000);
					
	}
	
	public void clickdel()  {
		this.delBtn.click();
		System.out.println("After delete button ");	
		
}
	 
	public void alertwindow() throws InterruptedException {
		System.out.println("Inside Alert");
		Alert alt=driver.switchTo().alert();
		System.out.println("after"+alt.getText());
		alt.accept();
	   
	}
	
	public String sucessmessage() {
		System.out.println("after delete button ");	
		String str=succtext.getText();
		String[] splited = str.split("\\s+");
		System.out.println("My string is "+splited[0]);
		String Actual=splited[0];
		return Actual;
		
	}
	}
		

