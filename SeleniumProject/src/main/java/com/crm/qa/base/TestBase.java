package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver;
	static Properties prop;
	
	public TestBase()
	{
		
		try {
			prop= new Properties();
			FileInputStream fis= new FileInputStream("C:\\Users\\q\\eclipse-workspace\\SeleniumProject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		 prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
public static void initialization() {
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
	}
	else if(browserName.equals("IE"))
	{
		WebDriverManager.iedriver().setup();
		WebDriver driver= new InternetExplorerDriver();
	}
	else  if(browserName.equals("FF")){
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}
	
}

