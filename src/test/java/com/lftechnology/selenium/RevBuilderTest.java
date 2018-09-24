package com.lftechnology.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RevBuilderTest {

	@Test
	public void verifyUnsuccessfulLogin() throws InterruptedException {
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("https://outdev-app.acustream.com/acustream/login.jsp");

		Assert.assertTrue("RevBuilder login screen should display",
				browser.getTitle().startsWith("AcuStream RevBuilder Login"));

		browser.findElement(By.id("login")).sendKeys("xxx");
		browser.findElement(By.id("password")).sendKeys("xxx");

		browser.findElement(By.className("login_controls_button")).findElement(By.tagName("a")).click();

		Thread.sleep(5000);

		Assert.assertTrue("Should show error message", "User ID or Password is invalid; please try again."
				.equals(browser.findElement(By.className("login_errortext")).getText()));

		browser.close();
		browser.quit();
	}

}
