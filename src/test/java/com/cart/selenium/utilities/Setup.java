package com.cart.selenium.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
	private static WebDriver driver;
	private InputStream inputStream = null;
	private Properties prop = null;
	private String propertyName = null;
	
	public Setup() {
		this.inputStream = getClass().getClassLoader().getResourceAsStream("openCart.properties");
		this.prop = new Properties();
		try {
			this.prop.load(this.inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void initSetup() throws InterruptedException {

		
		setPropertyName("opencart.home");
		String url = prop.getProperty(getPropertyName());
		
		
		
		setPropertyName("opencart.webdriver");
		String webdriver = prop.getProperty(getPropertyName());
		
		setPropertyName("opencart.driver");
		String chromedriver = prop.getProperty(getPropertyName());
		
		System.out.println("webdriver: " + webdriver);
		System.out.println("chromedriver: " + chromedriver);

		System.setProperty(webdriver,chromedriver);
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2000);

	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(String property) {
		this.prop.getProperty(property);		
	}
	
	




}
