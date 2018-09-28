Selenium
===========================

Source code to support getting started using Selenium WebDriver with Java


## Steps

* First install Java, Maven and IntelliJ
    * [Java Install Checklist](https://github.com/eviltester/startUsingJavaJUnit/blob/master/speedrun_install_java_checklist.md)
* Second install Firefox, GeckoDriver, Chrome and ChromeDriver
    * [WebDriver Install Checklist](https://github.com/eviltester/startUsingSeleniumWebDriver/blob/master/speedrun_install_checklist.md)


## Run a Test on your chosen browser

If you are on a mac and have allowed Remote Execution in the Safari browser then you can use the command line:

`mvn test -Dtest=MyFirstSafariTest`

If you are using Chrome and have added ChromeDriver to the path then use the command line:

`mvn test -Dtest=MyFirstChromeTest`


Do not run `mvn test` because some of the tests are Platform and WebDriver version dependent and at least one will probably fail.


## Running with Chrome

If you are using Chrome and have added ChromeDriver to the path then use the command line:

`mvn test -Dtest=MyFirstChromeTest`

## Running for RevBuilder
Copy app.properties.template file and paste as app.properties and change credentials
`mvn test -Dtest=RevBuilderTest`
