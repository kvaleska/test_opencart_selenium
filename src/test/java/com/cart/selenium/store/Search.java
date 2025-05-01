package com.cart.selenium.store;

import org.testng.annotations.Test;

import com.cart.selenium.utilities.Setup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Search {
	
	private Setup setup;

	
	WebDriver driver;
	By searchInputTextLocator = By.xpath("//*[@id=\"search\"]/input");
	By searchButtonLocator = By.xpath("//*[@id=\"search\"]/span/button");
	By linkProductLocator = By.xpath("//a[contains(text(), 'iPhone')]");
	
	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		setup = new Setup();
		setup.initSetup();
		driver = Setup.getDriver();		
	}

	@Test
	public void searchProduct() {
		
		WebElement searchInputText = driver.findElement(searchInputTextLocator);
		searchInputText.clear();
		searchInputText.sendKeys("iPhone");
		WebElement searchButton = driver.findElement(searchButtonLocator);
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement linkProduct = driver.findElement(linkProductLocator);
		linkProduct.click();
		
	}


	@AfterClass
	public void afterClass() {
		System.out.println("End search");
	}

}
