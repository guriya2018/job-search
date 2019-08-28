package com.automation.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	@FindBy(xpath=".//input[@type='text']")
	WebElement userName;
	
	@FindBy(xpath=".//input[@type='password']")
	WebElement passWord;
	
	@FindBy(xpath=".//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath=".//a[@class=\"navbar-brand\"]")
	WebElement crmLogo;
	
	@FindBy(xpath=".//a[contains(@href, 'logout')]")
	WebElement logOutBtn;
	
	public WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void lauchUrl(String url) {
		driver.get(url);
	}
	
	public boolean validateLoginPage() {
		return crmLogo.isDisplayed();
	}
		
	public void userLogin(String userName, String passWord) {
		this.userName.sendKeys(userName);
		this.passWord.sendKeys(passWord);
		submit.submit();
	}

}
