package com.cart.selenium.cart;

import org.testng.annotations.Test;

import com.cart.selenium.utilities.Setup;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class ViewCart {
	
	private WebDriver driver;
	private By buttonViewCartLocator = By.cssSelector("button[class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
	private By linkViewCartLocator = By.cssSelector("a[href = 'http://opencart.abstracta.us:80/index.php?route=checkout/cart']");
	private By linkproductLocator = By.xpath("//a[contains(text(), 'iPhone')]");
	private String product = "iPhone";
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("View Cart");
		driver = Setup.getDriver();
	}

	@Test
	public void viewCart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		WebElement buttonViewCart = driver.findElement(buttonViewCartLocator);
		buttonViewCart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		WebElement linkViewCart = driver.findElement(linkViewCartLocator);
		linkViewCart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		WebElement linkproduct = driver.findElement(linkproductLocator);
		assertEquals(product,linkproduct.getDomProperty("outerText"),"The item should be " + product + " and " + linkproduct.getDomProperty("outerText") + " was obtained");
	}
	

	@AfterTest
	public void afterTest() {
		System.out.println("End View Cart");
	}

}
