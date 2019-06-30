package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC1_AdminLogin {
private WebDriver driver; 
	
	public TC1_AdminLogin(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(css="button.btn.btn-primary")
	private WebElement loginBtn; 
	
	public void sendUser(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPass(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickAdminLoginBtn() {
		this.loginBtn.click(); 
	}
}
