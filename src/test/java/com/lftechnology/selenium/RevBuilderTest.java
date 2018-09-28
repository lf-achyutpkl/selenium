package com.lftechnology.selenium;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RevBuilderTest {
	
	private static WebDriver browser;
	
	@BeforeClass
	public static void init() {
		browser = new ChromeDriver();
	}
	
	@Test
	public void verifyUnsuccessfulLogin() throws InterruptedException {
		browser.navigate().to(ConfigReader.getProperty("LOGIN_URL"));

		Assert.assertTrue("RevBuilder login screen should display",
				browser.getTitle().startsWith("AcuStream RevBuilder Login"));

		browser.findElement(By.cssSelector(ConfigReader.getProperty("LOGIN_FIELD"))).sendKeys("xxx");
		browser.findElement(By.cssSelector(ConfigReader.getProperty("PASSWORD_FIELD"))).sendKeys("xxx");

		browser.findElement(By.cssSelector(ConfigReader.getProperty("LOGIN_BUTTON"))).click();

		(new WebDriverWait(browser, 300)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".login_errortext")));

		Assert.assertTrue("Should show error message", "User ID or Password is invalid; please try again."
				.equals(browser.findElement(By.className("login_errortext")).getText()));

		browser.close();
		browser.quit();
	}
	
	@Test
	public void verifySuccessfulLogin() throws InterruptedException {
		browser.navigate().to(ConfigReader.getProperty("LOGIN_URL"));
		
		// Enter login credentials and click login button
		browser.findElement(By.cssSelector(ConfigReader.getProperty("LOGIN_FIELD"))).sendKeys(ConfigReader.getProperty("USER_NAME"));
		browser.findElement(By.cssSelector(ConfigReader.getProperty("PASSWORD_FIELD"))).sendKeys(ConfigReader.getProperty("PASSWORD"));
		browser.findElement(By.cssSelector(ConfigReader.getProperty("LOGIN_BUTTON"))).click();

		// Wait until you land on homepage
		(new WebDriverWait(browser, 300)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ConfigReader.getProperty("WAIT_FOR_HOMEPAGE_ELEMENT"))));
		
		// Click Missing Charge link
		browser.findElement(By.cssSelector(ConfigReader.getProperty("MISSING_CHARGE_LINK"))).click();
		
		// Wait until you navigate to grid load view
		(new WebDriverWait(browser, 300)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ConfigReader.getProperty("WAIT_FOR_GRID_LOAD_VIEW_ELEMENT"))));
		
		Assert.assertTrue("Should show organization name", ConfigReader.getProperty("NAME_OF_HOSPITAL").equals(browser.findElement(By.cssSelector(ConfigReader.getProperty("HOSPITAL_TITLE_FIELD"))).getText()));
		
		// Click on missing status drop down
		browser.findElement(By.cssSelector("#x-auto-102")).click();
		// Select status - All 
		browser.findElement(By.cssSelector("#x-auto-101 > div:nth-child(1)")).click();
		// Click search button
		browser.findElement(By.cssSelector(ConfigReader.getProperty("GRID_LOAD_VIEW_SEARCH_BUTTON"))).click();
		
		// Wait until loading screen disappear
		(new WebDriverWait(browser, 300)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(ConfigReader.getProperty("GRID_LOAD_VIEW_LOADING_SPINNER"))));
		
		// Click Display Of Evidence link
		browser.findElement(By.cssSelector("#x-auto-992 > div > div > img")).click();
				
//		browser.close();
	}
	

}
