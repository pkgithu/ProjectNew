package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
@FindBy(name=" ")
WebElement userName;

@FindBy(name=" ")
WebElement passwordText;

@FindBy(name=" ")
WebElement loginBtn;

public LoginPage()
{
	PageFactory.initElements(driver, this);
}

public HomePage login(String userid,String password)
{
	userName.sendKeys("username");
	passwordText.sendKeys("password");
	loginBtn.click();
	return new HomePage();
}
}
