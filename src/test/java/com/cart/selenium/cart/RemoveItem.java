package com.cart.selenium.cart;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cart.selenium.utilities.Setup;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class RemoveItem {
	
	private WebDriver driver;
	private By buttonRemoveCartLocator = By.cssSelector("button[class='btn btn-danger']");
	private By linkproductLocator = By.xpath("//a[contains(text(), 'iPhone')]");
	private String product = "iPhone";
	private SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Remove Item");
		driver = Setup.getDriver();
	}

	@Test
	public void removeItem() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		WebElement buttonRemoveCart = driver.findElement(buttonRemoveCartLocator);
		buttonRemoveCart.click();		
		driver.navigate().refresh();

		try{
			System.out.println("Mostrar " + driver.findElement(linkproductLocator).isDisplayed());
			System.out.println("Mostrar " + driver.findElement(linkproductLocator).getDomProperty("outerText"));
			assertNotEquals   (product,driver.findElement(linkproductLocator).getDomProperty("outerText"),"The product should not be in the cart");
		}catch(NoSuchElementException e) {
			assertTrue(true);
		}	
		
		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("End Remove Item");
		driver.quit();
	}

}
