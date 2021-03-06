package com.lftechnology.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstChromeTest {

    @Test
    public void startWebDriver(){


/**

The following code is for the Chrome Driver.

You also need to download the ChromeDriver executable:

- https://sites.google.com/a/chromium.org/chromedriver/

You can easily install Chromedriver on windows using chocolatey:

- https://chocolatey.org/packages?q=ChromeDriver

If you are on a Mac then you could install ChromeDriver using HomeBrew

- http://brewformulas.org/Chromedriver

 */

        /**

         if you have not added ChromeDriver to the path then you need to tell Selenium WebDriver where
         the executable of the driver is located. You can do that using code like the following

         The `chromeDriverLocation` string should be the actual physical path of the executable.

         If you installed through Chocolatey or Homebrew then you should not need the following lines as the
         executable will be on your path.

         You can tell if the executable is on your path by typing `chromedriver` into a command prompt and if it is
         a recognised command then it is on your path.
         */

        // String currentDir = System.getProperty("user.dir");
        // String chromeDriverLocation = currentDir + "/tools/chromedriver/chromedriver.exe";
        // System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        //If you add the folder with chromedriver.exe to the path then you only need the following line
        // and you don't need to set the property as listed in the 3 lines above
        // e.g. D:\Users\Alan\Documents\github\startUsingSeleniumWebDriver\tools\chromedriver
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://google.com");

        Assert.assertTrue("title should start differently",
                            driver.getTitle().startsWith("Google"));

        driver.close();
        driver.quit();
    }
}
