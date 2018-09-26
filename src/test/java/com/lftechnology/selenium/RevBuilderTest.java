package com.lftechnology.selenium;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
//		browser.navigate().to("https://outdev-app.acustream.com/acustream/login.jsp");
//
//		Assert.assertTrue("RevBuilder login screen should display",
//				browser.getTitle().startsWith("AcuStream RevBuilder Login"));
//
//		browser.findElement(By.id("login")).sendKeys("xxx");
//		browser.findElement(By.id("password")).sendKeys("xxx");
//
//		browser.findElement(By.className("login_controls_button")).findElement(By.tagName("a")).click();
//
//		Thread.sleep(5000);
//
//		Assert.assertTrue("Should show error message", "User ID or Password is invalid; please try again."
//				.equals(browser.findElement(By.className("login_errortext")).getText()));

//		browser.close();
//		browser.quit();
	}
	
	@Test
	public void verifySuccessfulLogin() throws InterruptedException {
		browser.navigate().to("http://localhost:8080/acustream/login.jsp");
		
		// Enter login credentials and click login button
		browser.findElement(By.id("login")).sendKeys("xxx");
		browser.findElement(By.id("password")).sendKeys("xxx");
		browser.findElement(By.className("login_controls_button")).findElement(By.tagName("a")).click();

		// Wait until you land on homepage
		(new WebDriverWait(browser, 300)).until(ExpectedConditions.presenceOfElementLocated(By.className("mainframeHeaderBackground")));
		
		// Click Missing Charge link
		browser.findElement(By.cssSelector(".quickStartAnchor.x-component")).click();
		
		// Wait until you navigate to grid load view
		(new WebDriverWait(browser, 300)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".listPageSearchBackground.x-component.x-border")));
		
		Assert.assertTrue("Should show organization name", "CCF East Legacy Hospital".equals(browser.findElement(By.id("main_title")).getText()));
		
		// Click on missing status drop down
		browser.findElement(By.cssSelector("#x-auto-102")).click();
		// Select status - All 
		browser.findElement(By.cssSelector("#x-auto-101 > div:nth-child(1)")).click();
		// Click search button
		browser.findElement(By.cssSelector(".x-btn.x-component.x-btn-text-icon.x-unselectable  > tbody > tr:nth-child(2) > td.x-btn-mc > em > button")).click();
		
		// Wait until loading screen disapper
		(new WebDriverWait(browser, 300)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#worklistGrid > div.ext-el-mask-msg")));
		
		// Click Display Of Evidence link
		browser.findElement(By.cssSelector("#x-auto-992 > div > div > img")).click();
				
//		browser.close();
	}
	

}
