package com.lftechnology.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MyFirstSafariTest {

    @Test
    public void startWebDriver(){


/**

The following code is for the Safari Driver.

 This will only work on a Mac operating system.

 The safari driver is installed by default with the operating system. It should just work on a mac.

 You may need to change the safari properties to allow automated execution.

 - Safari \ Preferences \ Advanced \ [x] show develop menu in menu bar
 - Develop \ Allow Remote Execution

*/

        WebDriver driver = new SafariDriver();

        driver.navigate().to("http://google.com");

        Assert.assertTrue("title should start differently",
                            driver.getTitle().startsWith("Google"));

        driver.close();
        driver.quit();
    }
}
