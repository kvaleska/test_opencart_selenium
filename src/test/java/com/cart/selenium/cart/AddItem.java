package com.cart.selenium.cart;

import org.testng.annotations.Test;

import com.cart.selenium.utilities.Setup;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class AddItem {

	private WebDriver driver;
	private By buttonCartLocator = By.id("button-cart");
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Add Item");
		driver = Setup.getDriver();
	}

	@Test
	public void addItem() {		
		WebElement buttonCart = driver.findElement(buttonCartLocator);
		buttonCart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
	}

	@AfterClass
	public void afterClass() {
		System.out.println("End Add Item");
	}

}
