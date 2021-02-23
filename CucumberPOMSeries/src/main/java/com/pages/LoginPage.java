package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  
	
	private WebDriver driver;
	
	//1.By Locators
	private By emaild = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	//Constructor of the page class
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//3.page actions.features of the page,form of methods
	
	public String getLoginPageTitle()
	{
		//assertiosn should not be written in the page class
		//it has to be written in the testclass or step definition
		
		return driver.getTitle();
	}
	public boolean isForgotPwdLinkExist()
	{
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		
		driver.findElement(emaild).sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		
		driver.findElement(password).sendKeys(pwd);
	}
	
	
	public void clickOnLogin()
	{
		
		driver.findElement(signInButton).click();
	}
	
	
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emaild).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}
	
	
	
	
}
